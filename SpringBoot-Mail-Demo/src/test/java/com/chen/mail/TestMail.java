package com.chen.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 陈梓平
 * @date 2017/10/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {
    @Autowired
    private JavaMailSender javaMailSender;
    @Test
    public void test() throws MessagingException {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1013427541@qq.com");//发送者.
        message.setTo("1013427541@qq.com");//接收者.
        message.setSubject("fafasfsa");//邮件主题.
        message.setText("fasfasfaa");//邮件内容.
//        javaMailSender.send(message);//发送邮件
        javaMailSender.send(mimeMessage);//发送邮件
    }

}
