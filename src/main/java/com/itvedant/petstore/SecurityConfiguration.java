package com.itvedant.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.itvedant.petstore.services.AuthUserService;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfiguration {
        @Bean
        public SecurityFilterChain configure(HttpSecurity http)
                        throws Exception {
                http.csrf().disable()
                                .authorizeHttpRequests()
                                .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/products/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/registeredUsers").permitAll()
                                .requestMatchers("/register").permitAll()
                                .requestMatchers("/users/**").hasRole("HR")
                                .requestMatchers("/orderDetails/**").hasAnyRole("IT", "SALES")
                                .requestMatchers("/categories/**").hasAnyRole("HR", "SALES")
                                .anyRequest().authenticated()
                                .and()
                                .httpBasic()
                                .and()
                                .authenticationProvider(daoAuthenticationProvider());

                return http.build();
        }

        @Autowired
        private AuthUserService authUserService;

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setUserDetailsService(this.authUserService);
                provider.setPasswordEncoder(this.passwordEncoder());
                return provider;
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService users() {
                UserDetails user1 = User.builder()
                                .username("Prathamesh")
                                .password(passwordEncoder().encode("abc@123"))
                                .roles("IT")
                                .build();

                UserDetails user2 = User.builder()
                                .username("Omkar")
                                .password(passwordEncoder().encode("xyz@123"))
                                .roles("HR")
                                .build();

                UserDetails user3 = User.builder()
                                .username("Rashmi")
                                .password(passwordEncoder().encode("pqr@123"))
                                .roles("HR", "SALES")
                                .build();

                return new InMemoryUserDetailsManager(user1, user2, user3);
        }
}