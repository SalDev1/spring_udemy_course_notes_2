package com.salcorps.springbootdemo2.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       // Permits all requests inside the Web Application.
        http.csrf((csrf)->
                        csrf
                                .ignoringRequestMatchers("/saveMsg")
                                .ignoringRequestMatchers("/public/**")
                                .ignoringRequestMatchers(PathRequest.toH2Console())
                )
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/displayMessages").hasRole("ADMIN")
                                .requestMatchers("/closeMsg/**").hasRole("ADMIN")
                                .requestMatchers("/","/home").permitAll()
                                .requestMatchers("/holidays/**").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/saveMsg").permitAll()
                                .requestMatchers("/courses").permitAll()
                                .requestMatchers("/about").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/dashboard").authenticated()
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                )
                .formLogin((loginConfiguer)->
                        loginConfiguer.loginPage("/login")
                                .defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?error=true")
                                .permitAll()
                        ).logout(logoutConfigurer ->
                        logoutConfigurer
                                .logoutSuccessUrl("/login?logout=true")
                                .invalidateHttpSession((true))
                                .permitAll())

                .httpBasic(Customizer.withDefaults());

        http.headers(headersConfigurer -> headersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("54321")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
