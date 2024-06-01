package com.service;

import com.service.impl.ISendEmailService;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class SendEmailService implements ISendEmailService {
    @Override
    public int sendCodeChangePassword(String toEmail) {
        String from = "chinhlvde170423@fpt.edu.vn";
        String password = "q v w n y g y j q v p p c s g i";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        Session session = Session.getInstance(properties, auth);


        int code = new Random().nextInt(900000) + 100000;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            String content = "Gửi khách hàng của tôi,\n\n Đây là mã code chúng tôi gửi đến cho bạn được dùng để đổi mật khẩu, " +
                    "vui lòng không gửi mã code cho bất kì ai vì nó bảo mật.\n Mã code của bạn là " + code + ".\n\n Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi,\n Karma Shop.";
            message.setSubject("Đổi mật khẩu", "UTF-8");
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/plain;charset=UTF-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return code;
    }
}
