package com.codeknights.ProEstimates1.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 
import com.codeknights.ProEstimates1.services.MySQLUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private MySQLUserDetailsService mySQLUserDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
         .userDetailsService(mySQLUserDetailsService)
         .passwordEncoder(passwordEncoder());
    }
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				
				.anyRequest().permitAll();
		http
		.cors().and().csrf().disable();
	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
////				This is where we will probably have to add the Angular Front End work
////				once we know what it's called and what kind of file is use.  Just like
////				the JavaScript file "/js/**.js" below.
//				.antMatchers("/**","/", "/user", "/register","/login", "/contractors", "/js/**.js").permitAll()
//				.anyRequest().permitAll()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//	}
}
//				.anyRequest().authenticated()
