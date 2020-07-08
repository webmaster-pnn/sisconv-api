package br.mil.marinha.sisconvapi.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_MATCHERS_GET = { 
			"/proprietarios/**",
			"/veiculos/**",
			"/cor/**",
			"/montadora/**",
			"/posto/**",
			"/setor/**",
			"/usuarios/**",
			"/permissoes/**",
			"/cartoes/**"
			
	};

	private static final String[] PUBLIC_MATCHERS_POST = {
			"/proprietarios/**",
			"/veiculos/**",
			"/cor/**",
			"/montadora/**",
			"/posto/**",
			"/setor/**",
			"/usuarios/**",
			"/permissoes/**",
			"/cartoes/**"
	};

	private static final String[] PUBLIC_MATCHERS_DELETE = {
			"/proprietarios/**",
			"/veiculos/**",
			"/cor/**",
			"/montadora/**",
			"/posto/**",
			"/setor/**",
			"/usuarios/**",
			"/permissoes/**",
			"/cartoes/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_PUT = {
			"/proprietarios/**",
			"/veiculos/**",
			"/cor/**",
			"/montadora/**",
			"/posto/**",
			"/setor/**",
			"/usuarios/**",
			"/permissoes/**",
			"/cartoes/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll()
			.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
			.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
