package poo3.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userService = userDetailsService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Soluciona un bug que redirige a /?continue
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http
                .userDetailsService(userService)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/login", "/register").permitAll()
                        .requestMatchers("/index").authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index") // dirección predeterminada al iniciar sesión
                        .permitAll()
                        .and()
                )
                .requestCache((cache) -> cache
                        .requestCache(requestCache)
                )
                .logout(logout -> logout
                        .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
