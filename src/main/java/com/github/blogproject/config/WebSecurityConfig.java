package com.github.blogproject.config;

import com.github.blogproject.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.*;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userDetailService;

    // 스프링 시큐리티 기능 비활성화
    @Bean
    public WebSecurityCustomizer configure() {
        return (web -> web.ignoring().requestMatchers(toH2Console()).requestMatchers("/static/**"));
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize.requestMatchers("/login", "/signup", "/user").permitAll().anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer -> AbstractHttpConfigurer.loginPage("/login").defaultSuccessUrl("/articles"))
                .logout(AbstractHttpConfigurer -> AbstractHttpConfigurer.logoutSuccessUrl("/login").invalidateHttpSession(true))
                .csrf(AbstractHttpConfigurer:: disable)
                .build();
    }


}
