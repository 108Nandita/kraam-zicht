package com.project.kraamzicht.config;

import com.project.kraamzicht.filter.JwtRequestFilter;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.services.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    // PasswordEncoderBean. Deze kun je overal in je applicatie injecteren waar nodig.
    // Je kunt dit ook in een aparte configuratie klasse zetten.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Authenticatie met customUserDetailsService en passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(myUserDetailsService);
        return new ProviderManager(auth);
    }


    // Authorizatie met jwt
    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                                auth
                                        // Wanneer je deze uncomments, staat je hele security open. Je hebt dan alleen nog een jwt nodig.
//                .requestMatchers("/**").permitAll()
                                        .requestMatchers("/authenticate").permitAll()
                                        .requestMatchers("/authenticated").authenticated()
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/users/**").hasRole("ADMIN")
                                        .requestMatchers("/maternityNurse/**").hasRole("ADMIN")
                                        .requestMatchers("/client/**").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.GET, "/clientFiles").hasAnyRole("MATERNITYNURSE", "MIDWIFE")
//                                        .requestMatchers(HttpMethod.PUT, "/clientFiles/**").hasAnyRole("MATERNITYNURSE", "CLIENT")
//                                        .requestMatchers(HttpMethod.GET, "/clientFiles/{clientId}")
//                                        .requestMatchers("hasRole('CLIENT') and @Service.isClientOwner(authentication, #clientId)")
//                                        .requestMatchers(HttpMethod.PUT, "/clientFiles/{clientId}/indication").hasRole("MATERNITYNURSE")
//                                        .requestMatchers(HttpMethod.GET, "/clientFiles/{clientId}/indication").hasRole("MIDWIFE")
//                                        .requestMatchers(HttpMethod.POST, "/clientFiles/{clientId}/indication/approve").hasRole("MIDWIFE")
                                        .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
