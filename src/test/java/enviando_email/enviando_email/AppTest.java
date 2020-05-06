package enviando_email.enviando_email;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;


public class AppTest{
	
	private String user = "cursojspfulano@gmail.com";
	private String password = "Pe68288120";
	
	@Test
	public void  testeEmail() {
		
		try {
			
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); // autorização
		properties.put("mail.smtp.starttls", "true");// autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor Gmail google
		properties.put("mail.smtp.port", "465"); // Porta do servidor
		properties.put("mail.smtp.socketFactory", "465"); // porta a conectar pelo socket
		properties.put("mai.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(properties, new Authenticator(){
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
	
				return new PasswordAuthentication(user, password);
			}
		});
		
		Address[] toUser = InternetAddress.parse("daniel.dsc993@gmail.com");
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user));// Quem está enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // Email de destino
		message.setSubject("Email enviado por codigo java");// assunto do email
		message.setText("Daniel Viadoooooooooooooooooooooooooooooooooooooooooo");
		
		Transport.send(message);
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
 
