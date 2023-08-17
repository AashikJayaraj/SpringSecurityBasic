package com.security.security.config;


import com.security.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    UserSecurityService userSecurityService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests((requests)->
//                {
//                    try {
//                        requests.antMatchers("/home/open","/user/addUser","/user/*").permitAll()
//                                .antMatchers("/home/admin").hasRole("ADMIN")
//                                .anyRequest().authenticated().and().csrf().disable();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//        ).formLogin().permitAll();
        httpSecurity.authorizeHttpRequests().antMatchers("/home/open","/user/addUser","/user/*").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/home/admin").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();


        return httpSecurity.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userSecurityService);
        dao.setPasswordEncoder(passwordEncoder);
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }



}
