package Utils;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public void sendMail(String host, String from, String to) {
		//boolean debug = true;

		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", host);

		Session session = Session.getInstance(props, null);
		//session.setDebug(debug);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject("JavaMail Test");
			msg.setSentDate(new Date());
			msg.setText("JavaMail Test Mail");
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

