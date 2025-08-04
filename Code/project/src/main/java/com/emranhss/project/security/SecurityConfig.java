package com.emranhss.project.security;


import com.emranhss.project.jwt.JwtAuthenticationFilter;
import com.emranhss.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserService userService;

//    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
//        return
//                http
//                        .csrf(AbstractHttpConfigurer::disable)
//                        .cors(Customizer.withDefaults())
//                        .authorizeHttpRequests(
//
//                                req ->
//                                        req.requestMatchers("/api/user/", "/image/**")
//                                                .permitAll()
//                                                .requestMatchers("/api/jobseeker/")
//                                                .hasAnyAuthority("JOBSEEKER", "ADMIN")
//
//                        )
//                        .userDetailsService(userService)
//                        .
//
//    }


}



