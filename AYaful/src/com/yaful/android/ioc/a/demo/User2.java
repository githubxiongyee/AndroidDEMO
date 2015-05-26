package com.yaful.android.ioc.a.demo;

import com.yaful.android.ioc.db.annotation.Foreign;

public class User2 {
	
	private int id;
	private String content;
	private String content_des;

	/**
	 * 一个User对应多个User2
	 */
	@Foreign(column = "UserId", foreign = "id")
	public User user;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent_des() {
		return content_des;
	}

	public void setContent_des(String content_des) {
		this.content_des = content_des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
