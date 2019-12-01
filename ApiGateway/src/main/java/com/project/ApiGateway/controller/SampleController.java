package com.project.ApiGateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.ApiGateway.Dao.UserDao;
import com.project.ApiGateway.Impl.UserDetailServiceImplementation;
import com.project.ApiGateway.model.AuthToken;
import com.project.ApiGateway.model.SaveUserDto;
import com.project.ApiGateway.model.UserDto;
import com.project.ApiGateway.security.TokenProvider;

@CrossOrigin("*")
@RestController
public class SampleController {

	@Autowired
	UserDao userDao;
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(value="/get")
    public ResponseEntity<?> getAll() {
    	return ResponseEntity.ok(((UserDetailServiceImplementation) userDetailsService).getAll());
    }
    
    @RequestMapping(value = "/token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody UserDto loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );        
        return ResponseEntity.ok( new AuthToken(jwtTokenUtil.generateToken(authentication)));
    }
    
    @GetMapping("/getRole/{username}")
    public String getRole(@PathVariable String username) {
    	return userDao.findByUsername(username).getRole().getRoleName();
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody SaveUserDto loginUser) {
    	System.out.println("qwerty");
    	((UserDetailServiceImplementation) userDetailsService).saveUser(loginUser);
    }
}
