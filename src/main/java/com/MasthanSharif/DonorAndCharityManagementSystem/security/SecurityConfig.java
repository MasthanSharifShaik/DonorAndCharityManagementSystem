package com.MasthanSharif.DonorAndCharityManagementSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults()) // ✅ enable CORS
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // Allow static resources
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/favicon.ico",
                                "/**/*.css",
                                "/**/*.js",
                                "/**/*.jpg",
                                "/**/*.png",
                                "/**/*.jpeg",
                                "/**/*.gif",
                                "/**/*.svg"
                        ).permitAll()

                        // Allow user CRUD
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").permitAll()

                        // Everything else secured
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // ✅ CORS configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*"));
        // allows Railway domain + localhost + anything

        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        configuration.setAllowedHeaders(List.of("*"));

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
