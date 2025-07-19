package kr.co.bidworks.review3_myfirstwebapp.todos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.co.bidworks.review3_myfirstwebapp.todos.domain.Todo;
import kr.co.bidworks.review3_myfirstwebapp.todos.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	public List<Todo> readAllTodosByUsername(String username) {
		return todoRepository.findByUsername(username);
	}

	public void createTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteTodoById(int id) {
		todoRepository.deleteById(id);
	}

	public Optional<Todo> readTodoById(int id) {
		return todoRepository.findById(id);
	}

	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}

}
