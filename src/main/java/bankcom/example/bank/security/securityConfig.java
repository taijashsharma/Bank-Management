package bankcom.example.bank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity

    public class securityConfig {

        @Bean
        @Bean
        UserDetailsService myInMemoryUserDetailsService(){

            UserDetails user =  User
                    .withUsername("Abhishek")
                    .password("@bhi")
                    .roles("USER")
                    .build()
            UserDetails admin=  User
                    .withUsername("Bhavana")
                    .password("bhavana")
                    .roles("ADMIN")
                    .build()

            return new InMemoryUserDetailsManager(user,admin)
            @Bean
            PasswordEncoder passwordEncoder(){
                return new BCryptPasswordEncoder();
            }
        }
        SecurityFilterChain securityfilterChain(HttpSecurity httpSecurity) throws Exception{
            httpSecurity.authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/get/**")
                            .permitAll().anyRequest().authenticated())
                    .csrf(csrfConfig -> csrfConfig.disable())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .formLogin(Customizer.withDefaults())
                    .logout(Customizer.withDefaults());
            return httpSecurity.build();
        }

    }

