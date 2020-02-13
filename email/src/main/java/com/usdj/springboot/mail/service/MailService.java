package com.usdj.springboot.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author gerrydeng
 * @date 2019-07-30 22:36
 * @Description:
 */
@Service
public class MailService {

	//这个是发送人的用户名，如siertou@qq.com
	@Value("${spring.mail.username}")
	private String from;

	//用来发送邮件
	@Autowired
	private JavaMailSender mailSender;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @return void
	 * @Author ChenforCode
	 * @Description //TODO 发送简单的文本文件，to:收件人 subject:主题 content:内容
	 * @Date 11:00 2018/9/30
	 * @Param [to, subject, content]
	 **/
	public void sendSimpleMail (String to, String subject, String content){

		//创建一个简单的文本文件实例
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);
	}

	/**
	 * @return void
	 * @Author ChenforCode
	 * @Description //TODO 发送一个HTML邮件，to:收件人 subject:主题 content:内容
	 * @Date 15:01 2018/9/30
	 * @Param [to, subject, content]
	 **/
	public void sentHtmlMail (String to, String subject, String content ) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);

		//设置成true，会将这封邮件里边的html标签正常处理，否则会被当成文本处理
		helper.setText(content, true);

		mailSender.send(message);
	}

	/**
	 * @return void
	 * @Author ChenforCode
	 * @Description //TODO 发送一个带附件的邮件，to:收件人，subject:主题，content:主题，filePath:附件的路径
	 * @Date 15:26 2018/9/30
	 * @Param [to, subject, content, filePath]
	 **/
	public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();

		//设置邮件的一些基本信息
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(content);

		//设置附件
		FileSystemResource file = new FileSystemResource(new File(filePath));
		String filename = file.getFilename();
		helper.addAttachment(filename, file);

		//发送邮件
		mailSender.send(message);
	}

	public void sendInlineResourceMail(String to, String subject, String content, String rscId, String rscPath) {
		MimeMessage message = mailSender.createMimeMessage();

		logger.info("静态邮件发送开始：{}, {}, {}, {}, {}", to, subject, content, rscId, rscPath);
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);

			//构造邮件内部的图片资源
			FileSystemResource file = new FileSystemResource(new File(rscPath));
			helper.addInline(rscId, file);

			//发送邮件
			mailSender.send(message);
			logger.info("发送静态邮件成功！");
		} catch (MessagingException e) {
			logger.error("发送静态邮件失败", e);
		}
	}

}
