package com.poe.javatos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poe.javatos.service.ServiceUtilisateurImpl;
import com.poe.javatos.springsecurity.service.security.AppAuthProvider;

@Configuration
@EnableWebSecurity
@EnableWebMvc /**Gestion du MVC Web pour les WAR et les JSP **/
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	@Autowired
    ServiceUtilisateurImpl userDetailsService;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .exceptionHandling()
                .and()
                .authenticationProvider(getProvider())
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/Menu**").authenticated()
                .antMatchers("/admin/**").hasAuthority("Admin")
                .antMatchers("/commercial/**").hasAuthority("Commercial")
                .antMatchers("/magasinier/**").hasAuthority("Magasinier")
                .anyRequest().permitAll();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    /**
     * Configuration des chemins par défaut pour le menu et le formulaire
     * de connexion.
     */
       registry.addViewController("/").setViewName("menu");
       registry.addViewController("/login").setViewName("login");
    }
   
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	/**
    	 * Configuration très simple du dossier des JSP et
    	 * de la résolution des noms passés par les controller
    	 */
    	// TODO Auto-generated method stub
    	 registry.jsp("/WEB-INF/jsp/", ".jsp");
    	WebMvcConfigurer.super.configureViewResolvers(registry);
    }
     
    @Bean
    public AuthenticationProvider getProvider() {
    	AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;

    }
}
