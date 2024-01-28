package com.kildani.simplebanking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.kildani.simplebanking.service.security.ClientLoginService;

@Configuration
public class SimpleVaultSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(ClientLoginService clientLoginService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(clientLoginService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] whitelist = {
                "/css/**",
                "/images/**",
                "/create_account/**"
        };

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(whitelist)
                .permitAll()
                .anyRequest()
                .authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateLogin")
                        .defaultSuccessUrl("/dashboard/home")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}