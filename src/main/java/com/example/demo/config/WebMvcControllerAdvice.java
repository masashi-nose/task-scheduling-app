package com.example.demo.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.demo.service.TaskNotFoundException;

/**
 * コントローラアドバイスクラスです.
 * 
 * @author masashi.nose
 *
 */
@ControllerAdvice
public class WebMvcControllerAdvice {

	/**
	 * 入力値の空文字をnullに変換します.
	 * 
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * エラーが出たらカスタムページを表示します.
	 * 
	 * @param e
	 * @param model
	 * @return
	 */
	@ExceptionHandler(TaskNotFoundException.class)
	public String handleException(TaskNotFoundException e, Model model) {
		model.addAttribute("message", e);
		return "error/CustomPage";
	}
}
