package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "in28minutes","Get AWS Certified 1", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "in28minutes","Learn DevOps 1", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(++todosCount, "in28minutes","Learn Full Stack Development 1", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<Todo> findByUsername(final String username){
		Predicate<? super Todo> predicate = 
				new Predicate<Todo>() {
			public boolean test(Todo todos) {
				return todos.getUsername().equalsIgnoreCase(username);
			}
		};
		return todos.stream().filter(predicate).toList();
		
//		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(final int id) {
		 
//		 lambda in java
		Predicate<? super Todo> predicate = new Predicate<Todo>() {
			public boolean test(Todo todo) {
				return todo.getId() == id;
			}
		};
		todos.removeIf(predicate);
	}

	public Todo findById(final int id) {
		Predicate<? super Todo> predicate = new Predicate<Todo>() {
			public boolean test(Todo todo) {
				return todo.getId() == id;
			}
		};
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}