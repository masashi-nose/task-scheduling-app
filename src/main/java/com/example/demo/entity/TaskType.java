package com.example.demo.entity;

/**
 * task_typeテーブルのエンティティ.
 * 
 * @author masashi.nose
 *
 */

public class TaskType {
	/** ID */
	private Integer id;
	/** タスクタイプ */
	private String type;
	/** コメント */
	private String comment;

	@Override
	public String toString() {
		return "TaskType [id=" + id + ", type=" + type + ", comment=" + comment + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
