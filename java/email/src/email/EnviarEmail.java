package email;

import java.util.Properties;
import java.util.concurrent.Semaphore;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//http://www.wpsitecare.com/gmail-smtp-settings/
public class EnviarEmail extends Thread
{
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	private String cual;
	protected Semaphore oFinP3;

	public EnviarEmail(String cual,Semaphore oFinP3){
		this.cual = cual;
		this.oFinP3 = oFinP3;
		
	}
	
	 public void run()  {
		 try {
			oFinP3.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 try {
			this.generateAndSendEmail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oFinP3.release();
	 }		 
	 
	public void generateAndSendEmail() throws AddressException, MessagingException {
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("test1@crunchify.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "Test email by Crunchify.com JavaMail API example. Hilo:  " + this.cual  + "<br><br> Regards, <br>Crunchify Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully.." + this.cual );

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "joelsilva.1987@gmail.com", "l1l4m4mA$2710");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}