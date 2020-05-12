package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Task;

/**
 * サービスクラス用インターフェースです.
 * 
 * @author masashi.nose
 *
 */
public interface TaskService {
	List<Task> showAllTask();

	Optional<Task> getTask(Integer id);

	void save(Task task);

	void deleteById(Integer id);
}
