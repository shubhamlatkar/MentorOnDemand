package com.mod.course_service.controller;

import com.mod.course_service.document.Course;
import com.mod.course_service.document.Topic;
import com.mod.course_service.document.auth.Authorities;
import com.mod.course_service.document.auth.Login;
import com.mod.course_service.document.auth.Role;
import com.mod.course_service.document.dto.CourseRequest;
import com.mod.course_service.document.request.JwtResponse;
import com.mod.course_service.document.request.LoginRequest;
import com.mod.course_service.repository.CourseRepository;
import com.mod.course_service.repository.TopicRepository;
import com.mod.course_service.repository.auth.AuthoritiesRepository;
import com.mod.course_service.repository.auth.LoginRepository;
import com.mod.course_service.repository.auth.RoleRepository;
import com.mod.course_service.security.config.PasswordConfig;
import com.mod.course_service.security.jwt.JwtTokenUtil;
import com.mod.course_service.security.services.UserDetailsImpl;
import com.mod.course_service.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;


    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final LoginRepository loginRepository;
    private final RoleRepository roleRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private  final PasswordConfig passwordConfig;

    @Autowired
    private RestTemplate restTemplate;

    public CourseController(CourseRepository courseRepository, TopicRepository topicRepository, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtTokenUtil jwtTokenUtil, LoginRepository loginRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository, PasswordConfig passwordConfig) {
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.loginRepository = loginRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordConfig = passwordConfig;
    }

    @PostMapping("/")
    public ResponseEntity<?> postCourse(@RequestBody @Validated CourseRequest course) {
        Course saveCourse = new Course(course.getMentorId(), course.getTitle());
        course.getTopics().forEach(topic -> {
            Topic saveTopic = new Topic(topic.getName(), topic.getCompleted());
            saveCourse.addTopic(topicRepository.save(saveTopic));
        });
        courseRepository.save(saveCourse);
        return ResponseEntity.ok(courseRepository.findAll());
    }

//    @GetMapping("/insert/roles/")
//    public ResponseEntity<?> defaultGet() {
////        Topic topic = new Topic("angular", false);
////        topicRepository.save(topic);
////        courseRepository.save(new Course("13df", "MeanStack", Collections.singletonList(topicRepository.findByName("angular").orElse(null))));
//
//        Authorities read = new Authorities("course:read");
//        Authorities write = new Authorities("course:write");
//        authoritiesRepository.save(read);
//        authoritiesRepository.save(write);
//
//        Role userRole = new Role("USER");
//        userRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        roleRepository.save(userRole);
//
//        Role adminRole = new Role("ADMIN");
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("course:write").orElse(null));
//        roleRepository.save(adminRole);
//
//        Login shu = new Login("shu","shu@shu.com",passwordConfig.passwordEncoder().encode("12as"));
//        shu.addRole(roleRepository.findByRole("ADMIN").orElse(null));
//        loginRepository.save(shu);
//
//        Login knu = new Login("knu","knu@shu.com",passwordConfig.passwordEncoder().encode("12as"));
//        knu.addRole(roleRepository.findByRole("USER").orElse(null));
//        loginRepository.save(knu);
//
//        return ResponseEntity.ok(loginRepository.findAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable String id) {
        return ResponseEntity.ok(Objects.requireNonNull(courseRepository.findById(id).orElse(null)));
    }

    @GetMapping("/topic/{id}")
    public ResponseEntity<?> getTopics(@PathVariable String id) {
        return ResponseEntity.ok(Objects.requireNonNull(courseRepository.findById(id).orElse(null)).getTopics());
    }

//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> getJwtToken(@RequestBody LoginRequest request, HttpServletResponse response) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getUsername(),
//                            request.getPassword()
//                    )
//            );
//        } catch (BadCredentialsException e) {
//            throw e;
//        }
//
//        final UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(
//                request.getUsername()
//        );
//
//        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
//        Login user = loginRepository.findByUsername(request.getUsername()).orElse(null);
//
//        List<String> tokens = user.getActiveTokens() != null ? user.getActiveTokens() : new ArrayList<String>();
//        tokens.add(jwtToken);
//        user.setActiveTokens(tokens);
//
//        loginRepository.save(user);
//
//        final Cookie cookie = new Cookie("jwt", jwtToken);
//        cookie.setMaxAge(24 * 60 * 60); // expires in 1 days
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getId(), userDetails.getUsername()));
//    }

}
