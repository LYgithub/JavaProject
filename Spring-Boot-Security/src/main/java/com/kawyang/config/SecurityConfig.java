package com.kawyang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/**
 * 表示配置
 */
@EnableWebSecurity
/**
 * @author kawyang
    让配置生效
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 账户和角色
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //对密码进行编码
        auth.inMemoryAuthentication().passwordEncoder(new PasswordEncoder())
                .withUser("user").password(new PasswordEncoder().encode("000"))
                .roles("USER")
                .and().withUser("admin").password(new PasswordEncoder().encode("123"))
                .roles("ADMIN", "USER");

    }

    /**
     * 角色和权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/index").access("hasRole('ADMIN') or hasRole('USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll()//不需要验证
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}
