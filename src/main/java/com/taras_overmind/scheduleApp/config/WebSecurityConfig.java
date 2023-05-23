package com.taras_overmind.scheduleApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/registration").permitAll()
//                .antMatchers("/station/create").hasRole("ADMIN")
//                .antMatchers("/station/edit").hasRole("ADMIN")
//                .antMatchers("/train/create").hasRole("ADMIN")
//                .antMatchers("/train/edit").hasRole("ADMIN")
//                .antMatchers("/route/create").hasRole("ADMIN")
//                .antMatchers("/route/edit").hasRole("ADMIN")
//                .antMatchers("/carriage/create").hasRole("ADMIN")
//                .antMatchers("/carriage/edit").hasRole("ADMIN")
//                .antMatchers("/trip/create").hasRole("ADMIN")
                //.antMatchers("/smthing").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
//                .antMatchers("/smthing").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedPage("/access/denied");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(User.withUsername("taras_overmind").password("123wwe").roles("ADMIN").build());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder())
                .usersByUsernameQuery("select username, password from user where username = ?")
                .authoritiesByUsernameQuery("select username, role from user where username=?");
    }
}