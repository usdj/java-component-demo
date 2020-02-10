package com.usdj.demo.threadlocal;

import java.time.LocalDate;

/**
 * @Author gerrydeng
 * @Date 2020/2/10 9:11 PM
 * @Version 0.1
 * @Description: 用户entity
 */
public class User {
	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 用户名称
	 */
	private String name;

	/**
	 * 用户生日
	 */
	private LocalDate birthday;

	public Integer getUserId() {
		return userId;
	}

	public User setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public User setBirthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("userId=").append(userId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", birthday=").append(birthday);
		sb.append('}');
		return sb.toString();
	}
}
