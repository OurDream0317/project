package com.example.demo.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class simpleSend {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/simple")
    public String simpleSend() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("1484834931@qq.com");
        helper.setTo("1484834931@qq.com");
       mimeMessage.setContent("<html><body><a href='www.baidu.com'>智障，点一下</a></body></html>","text/html;charset=utf-8");
       mimeMessage.setText("123456\n789123\nwww.baidu.com\nwww.aliplay.com");
       mailSender.send(mimeMessage);
       return "login";
    }

}