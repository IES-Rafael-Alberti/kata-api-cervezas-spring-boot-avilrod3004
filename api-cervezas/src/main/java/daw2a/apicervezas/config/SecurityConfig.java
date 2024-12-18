package daw2a.apicervezas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desactivar CSRF usando el nuevo enfoque
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permitir todas las solicitudes
                );

        return http.build();
    }
}


