package kr.co.bidworks.review3_myfirstwebapp.admin.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.bidworks.review3_myfirstwebapp.admin.domain.AdminUser;
import kr.co.bidworks.review3_myfirstwebapp.admin.repository.AdminUserRepository;

@Service
public class AdminUserDetailsService implements UserDetailsService {

	private final AdminUserRepository adminUserRepository;

	public AdminUserDetailsService(AdminUserRepository adminUserRepository) {
		super();
		this.adminUserRepository = adminUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AdminUser adminUser = adminUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		System.out.println("admin:" + adminUser);

		// 사용자 권한을 GrantedAuthority 리스트로 변환
		List<GrantedAuthority> authorities = Collections
				.singletonList(new SimpleGrantedAuthority("ROLE_" + adminUser.getRole()));

		// private Collection<? extends GrantedAuthority> getAuthorities(String roles) {
		// // roles 문자열 (예: "ADMIN,USER")을 파싱하여 GrantedAuthority 객체로 변환
		// List<String> roleList = Arrays.asList(roles.split(","));
		// return roleList.stream()
		// .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim())) // Spring
		// Security는 "ROLE_" 접두사를 권장
		// .collect(Collectors.toList());
		// }

		// Spring Security의 User 객체를 반환
		return new User(adminUser.getUsername(), adminUser.getPassword(), authorities);
	}

}
