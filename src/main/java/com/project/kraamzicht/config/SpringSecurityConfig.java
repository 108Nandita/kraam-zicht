package com.project.kraamzicht.config;

import com.project.kraamzicht.filter.JwtRequestFilter;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.services.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public final MyUserDetailsService myUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    private final UserEntityRepository userEntityRepository;

    public SpringSecurityConfig(MyUserDetailsService myUserDetailsService, JwtRequestFilter jwtRequestFilter, UserEntityRepository userEntityRepository) {
        this.myUserDetailsService = myUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.userEntityRepository = userEntityRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(myUserDetailsService);
        return new ProviderManager(auth);
    }

    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                                auth
                                        .requestMatchers("/authenticate").permitAll()
                                        .requestMatchers("/authenticated").authenticated()
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/users/**").hasRole("ADMIN")
                                        .requestMatchers("/maternityNurse/**").hasRole("ADMIN")
                                        .requestMatchers("/client/**").hasAnyRole("ADMIN", "MATERNITY_NURSE")
                                        .requestMatchers(HttpMethod.DELETE, "/client/**").hasRole("ADMIN")
                                        .requestMatchers("/client-files/**").hasAnyRole("ADMIN", "MATERNITY_NURSE")
                                        .requestMatchers("/client-files-report/**").hasAnyRole("ADMIN", "MATERNITY_NURSE")
                                        .requestMatchers("/indications/**").hasAnyRole("ADMIN", "MATERNITY_NURSE")
                                        .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
