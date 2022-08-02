package br.com.bee.collect.crmmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/saved").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .csrf().disable()
                .httpBasic();
        return http.build();
    }
}
