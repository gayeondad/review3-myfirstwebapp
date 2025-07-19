package kr.co.bidworks.review3_myfirstwebapp.todos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.bidworks.review3_myfirstwebapp.todos.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByUsername(String username);

}
