package com.mod.authservice.security.jwt;

import com.mod.authservice.security.services.UserDetailsImpl;
import com.mod.authservice.security.services.UserDetailsServiceImpl;
import com.mod.authservice.service.AuthService;
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

@Component
public class JwtReqFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    private  AuthService authService;

    @Autowired
    public JwtReqFilter(JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

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

        if(!(authService.handleRequest(username,httpServletRequest.getRequestURL().toString(),jwt))) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized...");
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