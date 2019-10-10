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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.ApiGateway.Dao.UserDao;
import com.project.ApiGateway.Dto.UserObjDto;
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
    
    @GetMapping("/getUserObj/{username}")
    public UserObjDto getRole(@PathVariable String username) {
    	System.out.println(userDao.findByUsername(username));
    	return new UserObjDto(userDao.findByUsername(username).getId(), userDao.findByUsername(username).getUsername(), userDao.findByUsername(username).getRole().getRoleName());
    }
    
    @PostMapping("/login")
    public UserObjDto login(@RequestBody SaveUserDto loginUser) {
    	return new UserObjDto(userDao.findByUsername(loginUser.getUsername()).getId(), userDao.findByUsername(loginUser.getUsername()).getUsername(), userDao.findByUsername(loginUser.getUsername()).getRole().getRoleName());
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody SaveUserDto loginUser) {
    	((UserDetailServiceImplementation) userDetailsService).saveUser(loginUser);
    }
}
