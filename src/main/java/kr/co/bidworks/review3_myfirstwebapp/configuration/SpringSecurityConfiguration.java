package kr.co.bidworks.review3_myfirstwebapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.co.bidworks.review3_myfirstwebapp.admin.service.AdminUserDetailsService;

@Configuration
public class SpringSecurityConfiguration {
	private final AdminUserDetailsService adminUserDetailsService;

	public SpringSecurityConfiguration(AdminUserDetailsService adminUserDetailsService) {
		this.adminUserDetailsService = adminUserDetailsService;
	}

	@Bean
	public PasswordEncoder myPasswordEncorder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (API 개발 시 유용, 실제 서비스에서는 활성화 고려)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(
							"/public/**",
							"/login",
							"/",
							"/images/**", // 이미지 파일 (src/main/resources/static/images)
							"/webjars/**", // WebJars 사용 시 (예: Bootstrap WebJar)
							"/css/**",
							"/js/**"
						).permitAll() // 누구나 접근 가능
						.requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 권한만 접근 가능
						.anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
				).formLogin(form -> form.loginPage("/login") // 커스텀 로그인 페이지 URL
						.defaultSuccessUrl("/welcome", true) // 로그인 성공 시 리다이렉트 URL
						.permitAll() // 로그인 페이지는 누구나 접근 가능
				).logout(logout -> logout.logoutUrl("/logout") // 로그아웃 처리 URL
						.logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 리다이렉트 URL
						.permitAll() // 로그아웃 페이지는 누구나 접근 가능
				);

		return http.build();
	}

}
