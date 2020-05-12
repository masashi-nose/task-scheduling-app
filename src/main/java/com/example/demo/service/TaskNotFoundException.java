package com.example.demo.service;

/**
 * 例外クラスです.
 * 
 * @author masashi.nose
 *
 */
public class TaskNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(String message) {
		super(message);
	}
}
