package com.notification.dstplNotification.websocketSTOMP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ServiceConfig {

    @SuppressWarnings("removal")
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/gs/**")
                        .permitAll())
                .authorizeHttpRequests(requests -> requests
                        .anyRequest().authenticated())
                .formLogin()
                .and()
                .logout(logout -> logout.logoutSuccessUrl("/"))
                //.and()
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().sameOrigin()); 
        
     return http.build();
	}

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
	    UserDetails user = User.withDefaultPasswordEncoder()
	            .username("test")
	            .password("test")
	            .roles("USER")
	            .build();
	    
	    UserDetails user1 = User.withDefaultPasswordEncoder()
	            .username("test1")
	            .password("test")
	            .roles("USER")
	            .build();

	        UserDetails user2 = User.withDefaultPasswordEncoder()
	            .username("test2")
	            .password("test")
	            .roles("USER")
	            .build();

	        UserDetails user3 = User.withDefaultPasswordEncoder()
	            .username("test3")
	            .password("test")
	            .roles("USER")
	            .build();

	    return new InMemoryUserDetailsManager(user,user1,user2,user3);
	}

}
