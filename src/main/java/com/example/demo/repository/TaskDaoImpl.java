package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskType;

/**
 * TaskDaoインターフェースを実装したリポジトリです.
 * 
 * @author masashi.nose
 *
 */
@Repository
public class TaskDaoImpl implements TaskDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	/**
	 * taskテーブルからタスクを全件検索します.
	 *
	 */
	@Override
	public List<Task> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id, t.user_id, t.type_id, t.title, t.detail, t.deadline t.type, t.comment ");
		sql.append("FROM task t INNER JOIN task_type tt ON t.type_id = tt.id ORDER BY t.id");

//		タスク一覧をMapのListで取得
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql.toString());

//		return用の空のListを用意
		List<Task> list = new ArrayList<Task>();

		for (Map<String, Object> rs : resultList) {
			Task task = new Task();
			task.setId((Integer) rs.get("type_id"));
			task.setUserId((Integer) rs.get("user_id"));
			task.setTypeId((Integer) rs.get("type_id"));
			task.setDetail((String) rs.get("detail"));
			task.setTitle((String) rs.get("title"));
			task.setDeadline((LocalDateTime) rs.get("deadline"));

			TaskType taskType = new TaskType();
			taskType.setId((Integer) rs.get("type_id"));
			taskType.setType((String) rs.get("type"));
			taskType.setComment((String) rs.get("comment"));

			task.setTaskType(taskType);

			list.add(task);
		}
		return list;

	}

	/**
	 * taskテーブルからタスクを１件検索します.
	 *
	 */
	@Override
	public Optional<Task> findById(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id, t.user_id, t.type_id, t.title, t.detail, t.deadline t.type, t.comment ");
		sql.append("FROM task t INNER JOIN task_type tt ON t.type_id = tt.id ");
		sql.append("WHERE t.id = :id");

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

//		タスクを１件取得
		Map<String, Object> rs = jdbcTemplate.queryForMap(sql.toString(), param);

		Task task = new Task();
		task.setId((Integer) rs.get("type_id"));
		task.setUserId((Integer) rs.get("user_id"));
		task.setTypeId((Integer) rs.get("type_id"));
		task.setDetail((String) rs.get("detail"));
		task.setTitle((String) rs.get("title"));
		task.setDeadline((LocalDateTime) rs.get("deadline"));

		TaskType taskType = new TaskType();
		taskType.setId((Integer) rs.get("type_id"));
		taskType.setType((String) rs.get("type"));
		taskType.setComment((String) rs.get("comment"));

		task.setTaskType(taskType);

//		taskをOptionalでラップする
//		taskインスタンスを使用する際はisPresentで確認してください.
		Optional<Task> taskOpt = Optional.ofNullable(task);

		return taskOpt;
	}

	/**
	 * taskテーブルにインサートまたはアップデートします.
	 *
	 */
	@Override
	public void save(Task task) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(task);

		if (task.getId() == null) {
			String insertSql = "INSERT INTO task (user_id, type_id, title, detail, deadline) VALUES (:user_id, :type_id, :title, :detail, :deadline)";
			jdbcTemplate.update(insertSql, param);

		} else {
			String updateSql = "UPDATE task SET type_id = :type_id, title = :title, detail = :detail, deadline = :deadline)";
			jdbcTemplate.update(updateSql, param);

		}

	}

	/**
	 * IDに基づいてtaskテーブルからタスクを削除します.
	 *
	 */
	@Override
	public Integer deleteById(Integer id) {
		String sql = "DELETE FROM task WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		return jdbcTemplate.update(sql, param);
	}
}
