package kr.co.bidworks.review3_myfirstwebapp.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.bidworks.review3_myfirstwebapp.admin.domain.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

	Optional<AdminUser> findByUsername(String username);
}
