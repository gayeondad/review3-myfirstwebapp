package kr.co.bidworks.review3_myfirstwebapp.admin.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.bidworks.review3_myfirstwebapp.admin.domain.AdminUser;
import kr.co.bidworks.review3_myfirstwebapp.admin.repository.AdminUserRepository;

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

		List<GrantedAuthority> authorities = Collections
				.singletonList(new SimpleGrantedAuthority("ROLE_" + adminUser.getRole()));

		return new User(adminUser.getUsername(), adminUser.getPassword(), authorities);
	}

}
