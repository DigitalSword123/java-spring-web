package com.springboot.firstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;

@Entity
public class Todo {
	
	public Todo() {
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	@Size(min=10, message="Enter atleast 10 characters")
	private String Description;
	
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		Description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + Description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
}
