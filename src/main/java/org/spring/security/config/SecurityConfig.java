package org.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    DataSource dataSource;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().withUser(userBuilder.username("artem").password("artem").roles("USER"))
//                .withUser(userBuilder.username("andrey").password("andrey").roles("MANAGER"))
//                .withUser(userBuilder.username("vlad").password("vlad").roles("OWNER","MANAGER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("USER","MANAGER","OWNER")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .antMatchers("/owner_info/**").hasRole("OWNER").and().formLogin().permitAll();
    }
}
