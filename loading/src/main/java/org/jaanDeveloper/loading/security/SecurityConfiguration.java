package org.jaanDeveloper.loading.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    public CustomAuthSuccessHandler successHandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService getDetailService(){
        return new CustomUserServiceDetail();
    }
    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        /*http.authorizeHttpRequests(config->
                        config
                                .requestMatchers("/","/userReg","/saveUser").permitAll()
                                .requestMatchers("/user/**").authenticated())
                .formLogin(httpSecurityFormLoginConfigurer ->httpSecurityFormLoginConfigurer.loginPage("/signin")
                        .loginProcessingUrl("/ulogin")
                        .defaultSuccessUrl("/")
                        .permitAll());*/


        http.authorizeHttpRequests(config->
                        config
                                .requestMatchers("/user/**").hasRole("USER")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/**").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer ->httpSecurityFormLoginConfigurer.loginPage("/signin")
                        .loginProcessingUrl("/ulogin")
                        .successHandler(successHandler)
                        .permitAll());
        return http.build();
    }















     /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(config->
                        config
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/checkingAllLoad").hasRole("HR")
                                .requestMatchers("/kalyanPlay").hasRole("HR")
                                .requestMatchers("/mainPlay").hasRole("HR")
                                .requestMatchers("/milanPlay").hasRole("HR")
                                .requestMatchers("/rajdhaniPlay").hasRole("HR")
                                .requestMatchers("/timePlay").hasRole("HR")
                                .requestMatchers("/kalyanAscendingNumber").hasAnyRole("HR","ADMIN")
                                .requestMatchers("/mainAscendingNumber").hasAnyRole("HR","ADMIN")
                                .requestMatchers("/milanAscendingNumber").hasAnyRole("HR","ADMIN")
                                .requestMatchers("/rajdhaniAscendingNumber").hasAnyRole("HR","ADMIN")
                                .requestMatchers("/timeAscendingNumber").hasAnyRole("HR","ADMIN")
                                .requestMatchers("/gamePage").permitAll()
                                .anyRequest().authenticated())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/signin")
                        .loginProcessingUrl("/ulogin")
                        .defaultSuccessUrl("/")
                        .permitAll());
        return http.build();
    }*/
  /*@Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
      http.authorizeHttpRequests(config->
                      config
                              .requestMatchers("/").permitAll()
                              .requestMatchers("/checkingAllLoad").hasRole("HR")
                              .requestMatchers("/kalyanPlay").hasRole("HR")
                              .requestMatchers("/mainPlay").hasRole("HR")
                              .requestMatchers("/milanPlay").hasRole("HR")
                              .requestMatchers("/rajdhaniPlay").hasRole("HR")
                              .requestMatchers("/timePlay").hasRole("HR")
                              .requestMatchers("/kalyanAscendingNumber").hasAnyRole("HR","ADMIN")
                              .requestMatchers("/mainAscendingNumber").hasAnyRole("HR","ADMIN")
                              .requestMatchers("/milanAscendingNumber").hasAnyRole("HR","ADMIN")
                              .requestMatchers("/rajdhaniAscendingNumber").hasAnyRole("HR","ADMIN")
                              .requestMatchers("/timeAscendingNumber").hasAnyRole("HR","ADMIN")
                              .requestMatchers("/gamePage").permitAll()
                              .anyRequest().authenticated())
              .formLogin(Customizer.withDefaults());
      return http.build();
  }*/
}
