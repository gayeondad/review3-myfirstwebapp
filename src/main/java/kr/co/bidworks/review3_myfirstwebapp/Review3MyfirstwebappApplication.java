package kr.co.bidworks.review3_myfirstwebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.bidworks.review3_myfirstwebapp.admin.domain.AdminUser;
import kr.co.bidworks.review3_myfirstwebapp.admin.repository.AdminUserRepository;

@SpringBootApplication
public class Review3MyfirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Review3MyfirstwebappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (adminUserRepository.findByUsername("admin").isEmpty()) {
				AdminUser admin = new AdminUser();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("dummy"));
				admin.setRole("ADMIN");
				adminUserRepository.save(admin);
				System.out.println("Admin user 'admin' created.");
			}

			if (adminUserRepository.findByUsername("user").isEmpty()) {
				AdminUser user = new AdminUser();
				user.setUsername("user");
				user.setPassword(passwordEncoder.encode("dummy"));
				user.setRole("ADMIN");
				adminUserRepository.save(user);
				System.out.println("User 'user' created.");
			}
		};
	}

}
