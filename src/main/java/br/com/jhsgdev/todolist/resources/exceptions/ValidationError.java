package br.com.jhsgdev.todolist.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	
	private static final long serialVersionUID = 1L;

	private List<FildMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String message, Long timestamp) {
		super(status, message, timestamp);
	}

	public List<FildMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FildMessage(fieldName, message));
	}
		
}
