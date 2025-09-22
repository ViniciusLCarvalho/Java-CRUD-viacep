package pkgCepBuscar;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Emails {
	SimpleEmail email;
	String textoEmail;
	
	public boolean enviarEmail() {
		email = new SimpleEmail();
		
		textoEmail = "Prezados,\n	"
						+ "		Teste \n\n"
						+ "Atenciosamente,\n"
						+ "Tester";
		
		
		try {
			email.setHostName("smtp.googlemail.com"); //servidor SMTP
			email.setSmtpPort(587);
			email.setAuthentication("remetenteEmail@gmail.com", "password"); 
			email.setSSLOnConnect(true);
			email.setFrom("remetenteEmail@gmail.com"); //remetente
			email.setSubject("TESTE - CEP"); //assunto
			email.setMsg(textoEmail);
			email.addTo("destinatarioEmail@gmail.com"); //destinatario
			email.send();
		}catch(EmailException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
}
