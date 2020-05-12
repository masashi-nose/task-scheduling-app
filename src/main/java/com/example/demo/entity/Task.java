package com.example.demo.entity;

import java.time.LocalDateTime;

/**
 * taskテーブルのエンティティ.
 * 
 * @author masashi.nose
 *
 */

public class Task {

	/** ID */
	private Integer id;
	/** ユーザーID */
	private Integer userId;
	/** タイプID */
	private Integer typeId;
	/** タイトル */
	private String title;
	/** 期限 */
	private LocalDateTime deadline;
	/** タスクタイプインスタンス */
	private TaskType taskType;

	@Override
	public String toString() {
		return "Task [id=" + id + ", userId=" + userId + ", typeId=" + typeId + ", title=" + title + ", deadline="
				+ deadline + ", taskType=" + taskType + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

}
