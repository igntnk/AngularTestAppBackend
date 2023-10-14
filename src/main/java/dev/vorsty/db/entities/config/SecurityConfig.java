package dev.vorsty.db.entities.config;

import dev.vorsty.db.entities.auth.BaseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth)throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select username, password, enabled "
                                + "from users "
                                + "where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception{
        System.setProperty("http.protocols","TLSv1.2");
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests.
                    requestMatchers(HttpMethod.GET,"/api/home/**").permitAll().
                    requestMatchers(HttpMethod.GET,"/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole()).
                    requestMatchers(HttpMethod.POST,"/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole()).
                anyRequest().authenticated()).rememberMe(Customizer.withDefaults());

        return http.build();
    }
}
