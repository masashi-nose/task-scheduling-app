package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskDaoImpl;

/**
 * TaskServiceを実装したサービスクラスです.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDaoImpl taskDaoImpl;

//	private final TaskDao dao;
//
//	@Autowired
//	public TaskServiceImpl(TaskDao dao) {
//		this.dao = dao;
//
//	}

	/**
	 * タスクを全件表示します
	 *
	 */
	@Override
	public List<Task> showAllTask() {
		return taskDaoImpl.findAll();
	}

	/**
	 * タスクを１件検索します.
	 *
	 */
	@Override
	public Optional<Task> getTask(Integer id) {
		try {
			return taskDaoImpl.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TaskNotFoundException("タスクが見つかりませんでした。");
		}
	}

	/**
	 * タスクをインサートまたはアップデートします.
	 *
	 */
	@Override
	public void save(Task task) {
		taskDaoImpl.save(task);
	}

	/**
	 * IDでタスクを削除します.
	 *
	 */
	@Override
	public void deleteById(Integer id) {
		taskDaoImpl.deleteById(id);

	}

}
