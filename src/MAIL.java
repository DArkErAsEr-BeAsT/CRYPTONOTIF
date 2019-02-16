import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;;


public class MAIL extends Object {
	
	
//BLABLABLABLBALBALABOAFZAPOZFNPAZNF
	public static void main(String args[] ) {
		Timer timer1 = new Timer ();
		( timer1).scheduleAtFixedRate(new TimerTask() {
			@Override
			  public void run() {
		try {
			PARSER.main(args);;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  }
			},0, 10*60*10000);
		
	Timer timer = new Timer ();
	( timer).scheduleAtFixedRate(new TimerTask() {
		@Override
		  public void run() {
	try {
		sendMail();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  }
		},10*60*10, 10*60*10000);
	}
		public static void sendMail() throws IOException {
			String everything = null;
			BufferedReader br = new BufferedReader(new FileReader("topCurrencies.txt"));
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    everything = sb.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			    br.close();
			}
			
			  try{

			        Properties props = new Properties();
			        props.put("mail.smtp.host", "smtp.gmail.com"); 
			        props.put("mail.smtp.auth", "true");
			        props.put("mail.debug", "true"); 
			        props.put("mail.smtp.starttls.enable", "true");
			        props.put("mail.smtp.port", "465");
			        props.put("mail.smtp.socketFactory.port", "465");
			        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			        props.put("mail.smtp.socketFactory.fallback", "false");

			        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {

			        	protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			                return new javax.mail.PasswordAuthentication(
			                    "dcolonna12.dc@gmail.com", "hxaUcYnfFcy39zV");// Specify the Username and the PassWord
			            }
			    });
			        /*
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication("dcolonna12.dc@gmail.com", "PIERRE0802");
			            }
			        });

*/
			        Message msg = new MimeMessage( mailSession );
			        String message = "CRYPTOO";
			        msg.setHeader("Content-Type", "text/html");

			        msg.setFrom( new InternetAddress( "dcolonna12.dc@gmail.com" ) );
			        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse("colonna.david0@gmail.com") );
			         msg.addRecipient(Message.RecipientType.TO, new InternetAddress("combremontantoine@gmail.com"));;
			         msg.setContent(everything, "text/html");;

			        msg.setSentDate( new Date());
			        msg.setSubject( "Hello World!" );
			        msg.setText(everything);;


			        Transport.send(msg);

			    }catch(Exception E){
			        System.out.println( "Oops something has gone pearshaped!");
			        System.out.println( E );
			    }

			}
		


	}


