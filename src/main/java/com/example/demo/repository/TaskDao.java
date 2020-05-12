package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Task;

/**
 * リポジトリ用のインターフェースです.
 * ID検索はOptional型にしています.
 * 
 * @author masashi.nose
 *
 */
public interface TaskDao {
	List<Task> findAll();
	Optional<Task> findById(Integer id);
	void save(Task task);
	Integer deleteById(Integer id);
	

}
