package kr.co.bidworks.review3_myfirstwebapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

}
