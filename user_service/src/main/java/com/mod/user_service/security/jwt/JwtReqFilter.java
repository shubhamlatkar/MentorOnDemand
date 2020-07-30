package com.mod.user_service.security.jwt;

import com.mod.user_service.document.auth.Login;
import com.mod.user_service.repository.auth.LoginRepository;
import com.mod.user_service.security.services.UserDetailsImpl;
import com.mod.user_service.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtReqFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;

    private final LoginRepository loginRepository;

    @Autowired
    public JwtReqFilter(JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService, LoginRepository loginRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.loginRepository = loginRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException, IOException {

        final String authorization = httpServletRequest.getHeader("Authorization");

        Cookie[] cookies = httpServletRequest.getCookies();
        String cookieJWT = null;
        if (cookies != null) {
            cookieJWT = Arrays.stream(cookies)
                    .map(Cookie::getValue).findFirst().orElse(null);
        }

        String username = null;
        String jwt = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            username = jwtTokenUtil.getUsernameFromToken(jwt);
        } else if (cookieJWT != null) {
            username = jwtTokenUtil.getUsernameFromToken(cookieJWT);
        }

        Login user = loginRepository.findByUsername(username).orElse(null);
        String finalJwt = jwt;
        if (user != null) {
            List<String> activeTokens = user.getActiveTokens();
            if (!activeTokens.contains(finalJwt.toString()) && username != null)
                httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            if (httpServletRequest.getRequestURL().toString().contains("/logmeout")) {
                activeTokens = activeTokens.stream().filter(token -> {
                    boolean isTokePresent = token.toString().equals(finalJwt.toString());
                    return !(isTokePresent);
                }).collect(Collectors.toList());
                user.setActiveTokens(activeTokens);
                loginRepository.save(user);
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );
            usernamePasswordAuthenticationToken
                    .setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                    );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}