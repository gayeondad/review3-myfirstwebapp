package kr.co.bidworks.review3_myfirstwebapp.todos.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import kr.co.bidworks.review3_myfirstwebapp.todos.domain.Todo;
import kr.co.bidworks.review3_myfirstwebapp.todos.service.TodoService;

@Controller
@SessionAttributes("_SESSION")
public class TodoController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@GetMapping("/")
	public String showRootPage(ModelMap model) {
		if (model.getAttribute("_SESSION") == null) {
			return "redirect:login?username=veronika";
		}
		return "welcome";
	}

	@RequestMapping("list-todos")
	public String showListTodosPage(ModelMap model) {
		if (model.getAttribute("_SESSION") == null) {
			return "redirect:login?username=veronika";
		}
		String username = model.getAttribute("_SESSION").toString();
//		logger.debug("session name is {}", username);
		List<Todo> todos = todoService.readAllTodosByUsername(username);
//		logger.debug("todos is {}", todos);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.getAttribute("_SESSION");
		todo.setUsername(username);
		todo.setDone(false);
		todoService.createTodo(todo);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo")
	public String destroyTodo(@RequestParam("id") int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam("id") int id, ModelMap model) {
		Optional<Todo> todo = todoService.readTodoById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.getAttribute("_SESSION");
		todo.setUsername(username);
		todo.setDone(false);
		todoService.updateTodo(todo);

		return "redirect:list-todos";
	}
}
