package com.usdj.springboot.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-30 22:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService mailService;



	@Test
	public void sendSimpleMail() {
		String content = "this is a test";
		mailService.sendSimpleMail("denggerry@163.com", "Java Demo", content);
	}
}