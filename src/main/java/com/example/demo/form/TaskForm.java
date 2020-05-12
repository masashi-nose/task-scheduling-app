package com.example.demo.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * リクエストパラメータを受け取るフォーム.
 * 
 * @author masashi.nose
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskForm {
	@Digits(integer = 1, fraction = 0)
	private Integer typeId;

	@NotBlank(message = "タイトルを入力してください。")
	@Size(min = 1, max = 20, message = "20文字以内で入力してください。")
	private String title;

	@NotBlank(message = "内容を入力してください。")
	private String detail;

	@NotNull(message = "期限を設定してください。")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Future(message = "期限が過去に設定されています。")
	private LocalDateTime deadline;

	/** タスクがすでに設定されたものかどうか判定します. */
	public boolean isNewTask;

}
