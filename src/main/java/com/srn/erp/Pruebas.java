package com.srn.erp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import oracle.jdbc.pool.OracleDataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import framework.applicarionServer.bm.Seguridad.DesEncriptarCadena;
import framework.applicarionServer.bm.Seguridad.EncriptarCadena;

class MyPrintable implements Printable {
	  public int print(Graphics g, PageFormat pf, int pageIndex) {
	    if (pageIndex != 0)
	      return NO_SUCH_PAGE;
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setFont(new Font("Serif", Font.PLAIN, 36));
	    g2.setPaint(Color.black);
	    g2.drawString("www.java2s.com", 100, 100);
	    Rectangle2D outline = new Rectangle2D.Double(pf.getImageableX(), pf.getImageableY(), pf
	        .getImageableWidth(), pf.getImageableHeight());
	    g2.draw(outline);
	    return PAGE_EXISTS;
	  }
	}

public class Pruebas {
	
	
	 	
	
	

	public static String smtpServer;
	public static String userName;
	public static String password;
	
	private static boolean validarClave(String patron,String password) {
		Pattern pattern = Pattern.compile(patron);;
		Matcher matcher;
		matcher = pattern.matcher(password);
		return matcher.matches();		
		
	}
		

	public static void main(String[] args) throws IOException, SQLServerException, SQLException, ClassNotFoundException, Exception {

		
		double importe = 123;
		String importeString = String.format("%.02f", importe);
		importeString = importeString.replace(",","");
		importeString = importeString.replace(".","");
		System.out.print(importeString);
		if (1==1) return;
		
		
		String nroFactura = "123456789012345678901234567890j";
		if (nroFactura.length()>30)
			nroFactura = nroFactura.substring(0,30);
		
		System.out.println(nroFactura+"fin");
		
		if (1==1) return;
		
		String nro = "";
		for(int i=0;i<nroFactura.length();++i) {
			String digito = nroFactura.substring(nroFactura.length()-i-1,nroFactura.length()-i+1-1);
			try {
			        int digitoNumerico = Integer.parseInt(digito);
			    } catch (NumberFormatException nfe) {
			        digito = "";
			    }
			if (digito.equals("")) break;
			nro = digito  + nro;		
			
		}
		
		System.out.println(new Integer(nro));
		
		if (1==1) return;
		
		// ENCRIPTAR LAS SIGUIENTE CLAVE
		/*String a1 = "C:\\BORRAR\\\r\n";
		String b2 = "3001";*/
		
		if (1==1) {
			
			System.out.println("salida:"+DesEncriptarCadena.getCadenaDesencriptada("NMtrybZtK3g="));
			
			if (1==1) return;
			
		}
		
		 if (validarClave("((?=.*[a-zA-Z])(?=.*[0-9@#$%]).{1,20})","fdsfhuier32")) {
			 System.out.println("OK");
		 } else {
			 System.out.println("error");
		 }
		 
		 if (1==1) return;
		
		//mail1();
		
		//if (1==1) return;
		
		sendEmail("autogestionCPM@cbasa-ciesa.com.ar","snimo@cbasa-ciesa.com.ar","Olvidó su clave","<html><head></head><body><img src=\'cid:image\'>La clave <br><b>para</b> ingresar es XYZ</body></html>");
		
		if (1==1) return;
	
		 PrinterJob pj = PrinterJob.getPrinterJob();

		    PageFormat pf = pj.defaultPage();
		    Paper paper = new Paper();
		    double margin = 36; // half inch
		    paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
		        - margin * 2);
		    pf.setPaper(paper);

		    pj.setPrintable(new MyPrintable(), pf);
		    //if (pj.printDialog()) {
		      try {
		        pj.print();
		      } catch (PrinterException e) {
		        System.out.println(e);
		      }
		    //}
		  
	
	
		if (1==1) return;
		
		String usuario = "DMENORQUE";
		
		int pos = usuario.indexOf("\\");
		
		String onlyUser = usuario.substring(pos+1,usuario.length());
		String usuFinal = onlyUser;
		if (onlyUser.length()>8)
			usuFinal = onlyUser.substring(0,8); 
		
		System.out.println(usuFinal);
		
		
		if (1==1) return;
		
		System.out.println("12345678".substring(0,4));
		
		if (1==1) return;
		
		sendEmail("snimo@cbasa-ciesa.com.ar","snimo@cbasa-ciesa.com.ar","Olvidó su clave","La clave <br><b>para</b> ingresar es XYZ");
		
		/*File f = new File(a1.replace("\r", "").replace("\n","").trim()+b2);
		if (f.exists()==false) return;*/
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse("31/01/2014");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		
		System.out.println(date);
		
		
		
		System.out.println(EncriptarCadena.getCadenaEncriptada("EL98nBw0w2"));
		
		if (1==1) return;
		
		OracleDataSource ods1 = new OracleDataSource();
		java.util.Properties prop1 = new java.util.Properties();
		
		/*prop1.setProperty("ConnectionWaitTimeout", "5");
		ods1.setURL("jdbc:oracle:thin:@//172.24.190.207:1521/uterrhhh.oper.cbasa-ciesa.com.ar");
		ods1.setUser("SIG");
		ods1.setPassword("SIG_TEST");
		ods1.setConnectionCacheProperties(prop1);  // set properties*/
		
		//prop1.setProperty("ConnectionWaitTimeout", "5");
		prop1.setProperty("ConnectionWaitTimeout", "5");
		//ods1.setURL("jdbc:oracle:thin:@//172.24.190.207:1521/uterrhhh.oper.cbasa-ciesa.com.ar");
		ods1.setURL("jdbc:oracle:thin:@172.24.190.29:1521:uterp");
		ods1.setUser("tablero_control");
		ods1.setPassword("tablero_control");
		ods1.setConnectionCacheProperties(prop1); // set properties
		
		
		Locale.setDefault(Locale.ENGLISH);
		
		ods1.getConnection();
		
		System.out.println("Fin");		
		
		if (1==1) return;
		
		OracleDataSource ods = new OracleDataSource();
		java.util.Properties prop = new java.util.Properties();

		prop.setProperty("ConnectionWaitTimeout", "5");
		ods.setURL("jdbc:oracle:thin:@//172.24.190.207:1521/uterrhh.oper.cbasa-ciesa.com.ar");
		ods.setUser("SIG");
		ods.setPassword("SIG_TEST");
		ods.setConnectionCacheProperties(prop); // set properties

		Locale.setDefault(Locale.ENGLISH);
		
		ods.getConnection();	
		
		System.out.println("Termino");
		
		if (1==1) return;
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String serverName = "172.24.195.23\\Payroll";
		String puerto = "";
		String baseDeDatos = "hipodromo_payroll";
		String user = "sig";
		String password = "sig";
		
		//":"+puerto+
		
		String connectionUrl = "jdbc:sqlserver://"+serverName+":0;" +
		   "databaseName="+baseDeDatos+";user="+user+";password="+password+";";
		Connection con = null;
		boolean error = false;
		String mensError = "";
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			error = true;
			mensError = e1.getMessage();
		}		
		
		
		System.out.println("prueba");
		
		if (1==1)
			return;
		
		
		String cadenaNroTarjeta = "27139835";
		StringBuffer nroEnHexa = new StringBuffer("");
		
		int nroTarj = 0;
		String nroTarjeta = "";
		String fc = "";
		
		for (int i = cadenaNroTarjeta.length()-1; i >= 0; --i) {
			System.out.println(cadenaNroTarjeta.charAt(i));
			
			++nroTarj;
			
			if ((nroTarj>=1) && (nroTarj<=5)) {
				nroTarjeta = cadenaNroTarjeta.charAt(i) + nroTarjeta ;
			}
			
			if (nroTarj>5) {
				fc = cadenaNroTarjeta.charAt(i) + fc ;
			}
			
		}	
		
		// Recorrer el Nro. de Tarjeta y pasarlo a HEXA
		String binarioNroTarj = Integer.toBinaryString(new Integer(nroTarjeta));
		if (binarioNroTarj.length()<17) {
			int agregarCerozIzq = 17-binarioNroTarj.length();
			for(int z=1;z<=agregarCerozIzq;++z) {
				binarioNroTarj = "0"+binarioNroTarj; 
			}
		}
		
		// Recorrer el Faciliti CODE y pasarlo e HEX
		String binarioFC = Integer.toBinaryString(new Integer(fc));
		if (binarioFC.length()<15) {
			int agregarCerozIzq = 15-binarioFC.length();
			for(int z=1;z<=agregarCerozIzq;++z) {
				binarioFC = "0"+binarioFC; 
			}
		}
		
		String nroFinalDecimal = "0001100"+ binarioFC + binarioNroTarj + "1";
		String valorHexaFinal = "";
		
		// Leer todos los decimales
		String cada4Digitos = "";
		int contarDig = 0;
		
		boolean procesarHexa = false;
		
		for(int i=nroFinalDecimal.length()-1;i>=0;--i) {

			if ((contarDig>=0) && (contarDig<=3)) {
				cada4Digitos = nroFinalDecimal.charAt(i) + cada4Digitos ;
				
				if (contarDig==3) {
					valorHexaFinal = getHEXFromBinario(cada4Digitos) + valorHexaFinal;
					contarDig = 0;
					cada4Digitos = "";
					continue;
				}
			} 
			
			++contarDig;
			
		}
		
		if (!(cada4Digitos.equals("")) && (cada4Digitos.length()<4)) {
			int agregarCerozIzq = 4-cada4Digitos.length();
			for(int z=1;z<=agregarCerozIzq;++z) 
				cada4Digitos = "0"+cada4Digitos;	
		}
		
		if (!(cada4Digitos.equals(""))) {
			
			// Procesar cada4Digitos
			
			valorHexaFinal = getHEXFromBinario(cada4Digitos) + valorHexaFinal;
		}
		
		System.out.println(valorHexaFinal);
		System.out.println(Integer.toHexString(new Integer(nroFinalDecimal)).toString());
		
		
		
		
		System.out.println(nroTarjeta);
		System.out.println(fc);
		System.out.println(binarioNroTarj);
		System.out.println(binarioFC);
		
		if (1==1) return;
		
		String binario = getBinarioFromHEX("18043d3737");
		
		// Empezando de Atras para adelante tomar los 17 bits
		
		//String parteTarjeta = "";
		fc = "";
		
		int c = 0;
		boolean pr = true;
		for(int j=binario.length()-1;j>=0;--j) {
			
			if ((pr != true) && (c<=17)) {
				nroTarjeta = binario.charAt(j) + nroTarjeta;
			}
			
			pr = false;
			
			if ((c>17) && (c<=32)) {
				fc = binario.charAt(j) + fc ;
			}
			
			++c;
			
		}
		
		String nroFinal = new Integer(Integer.parseInt(fc,2)).toString()+new Integer(Integer.parseInt(nroTarjeta,2)).toString();
				
		
		System.out.println(nroTarjeta);
		System.out.println(fc);
		System.out.println(nroFinal);
		
		
		System.out.println("");
		System.out.println(binario);
		
		
		
		
		if (1==1)
			return;

		ods = new OracleDataSource();
		prop = new java.util.Properties();

		prop.setProperty("ConnectionWaitTimeout", "5");
		// prop.setProperty("InactivityTimeout", "1800"); // seconds
		// prop.setProperty("AbandonedConnectionTimeout", "900"); // seconds
		// prop.setProperty("MaxStatementsLimit", "1000");
		// prop.setProperty("PropertyCheckInterval", "900"); // seconds
		Locale.setDefault(Locale.ENGLISH);
		ods.setURL("jdbc:oracle:thin:@//172.24.198.44:1521/uterrhh.oper.cbasa-ciesa.com.ar");

		// ods.setDriverType("thin");
		// ods.setServiceName("XE");
		// ods.setPortNumber(1521);
		ods.setUser("SIG");
		ods.setPassword("SIG");
		// ods.setConnectionCachingEnabled(true);
		ods.setConnectionCacheProperties(prop); // set properties

		ods.getConnection();
		
		System.out.println("sdhu");

		if (1 == 1)
			return;

		System.out.println(15 % 12);
		System.out.println("2012.07".substring(0, 4));
		System.out.println("2012.07".substring(5, 7));

		if (1 == 1)
			return;

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(sdf.format(cal.getTime()));

		if (1 == 1)
			return;

		SQLServerDataSource sqlds = new SQLServerDataSource();
		sqlds.setServerName("172.24.198.29");
		sqlds.setPortNumber(1433);

		sqlds.setIntegratedSecurity(false);

		sqlds.setUser("sig");
		sqlds.setPassword("sig");
		java.sql.Connection a = sqlds.getConnection();
		a.setTransactionIsolation(com.microsoft.sqlserver.jdbc.SQLServerConnection.TRANSACTION_READ_UNCOMMITTED);
		a.setAutoCommit(false);
		PreparedStatement sqlInsert = null;
		sqlInsert = a.prepareStatement("insert into SEQ_DBTipoZona (SeqVal) VALUES ('1') ");
		sqlInsert.executeUpdate();

		java.sql.Connection b = sqlds.getConnection();
		b.setTransactionIsolation(com.microsoft.sqlserver.jdbc.SQLServerConnection.TRANSACTION_READ_UNCOMMITTED);
		b.setAutoCommit(false);
		PreparedStatement sqlInsert1 = null;
		sqlInsert1 = b.prepareStatement("insert into SEQ_DBTipoZona (SeqVal) VALUES ('2') ");
		sqlInsert1.executeUpdate();
		a.rollback();
		b.commit();

		return;

	}
	
	
	 public static String getBinarioFromHEX(String inputHex) {
	
	 String[]hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};  
	 String[]binary={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};  
	   
	 String userInput=inputHex;  
	 String result="";  
	 for(int i=0;i<userInput.length();i++)  
	 {  
	  char temp=userInput.charAt(i);  
	  String temp2=""+temp+"";  
	  for(int j=0;j<hex.length;j++)  
	  {  
	   if(temp2.equalsIgnoreCase(hex[j]))  
	   {  
	    result=result+binary[j];  
	   }  
	  }  
	 }
	 return result;
	 }
	 
	 public static String getHEXFromBinario(String inputHex) {
			
		 String[]hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};  
		 String[]binary={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};  
		   
		 String result="";  
		  
		  for(int j=0;j<binary.length;j++)  
		  {  
		   if(inputHex.equalsIgnoreCase(binary[j]))  
		   {  
		    result=result+hex[j];  
		    break;
		   }  
		  }  
		 return result;
	}	 
	 
	 private static void mail1() throws MessagingException {
		 // create a message
		 
		 if (Pattern.matches("(?=..*[0-9])","1")) {
			 System.out.println("OK");
		 } else {
			 System.out.println("error");
		 }
		 
		 if (1==1) return;
		 
		 smtpServer = "mail.oper.cbasa-ciesa.com.ar";
			userName = "autogestionCPM@cbasa-ciesa.com.ar";
			password = "asd789hj";

				Properties props = System.getProperties();
				props.put("mail.smtp.host", smtpServer);
				props.put("mail.smtp.password", password);
				props.put("mail.smtp.user", userName);
				props.put("mail.smtp.userName", userName);
				// SMTP server authentication is set to false, by default. Setting
				// it to true as shown below
				props.put("mail.smtp.auth", "true");
				Session session = Session.getDefaultInstance(props, null);		 
		    MimeMessage msg = new MimeMessage(session);
		    msg.setRecipients(Message.RecipientType.TO, "snimo@cbasa-ciesa.com.ar");
		    msg.setSubject("tema principal");

		    // create and fill the first message part
		    MimeBodyPart mbp1 = new MimeBodyPart();
		    mbp1.setContent("cuerpo principal", "text/html");

		    // create the second message part
		    MimeBodyPart mbp2 = new MimeBodyPart();
		    // attach the file to the message
		        DataSource source = new FileDataSource(new File("C:\\1\\100156.jpg"));
		        mbp2.setDataHandler(new DataHandler(source));
		        mbp2.setFileName("image.png");
		        mbp2.setHeader("Content-ID", "<image_cid>"); // cid:image_cid
		    // create the Multipart and add its parts to it
		    Multipart mp = new MimeMultipart();
		    mp.addBodyPart(mbp1);
		    mp.addBodyPart(mbp2);
		    // add the Multipart to the message
		    msg.setContent(mp);
		    // send the message
		    
		    Transport.send(msg);		 
	 }

	public static synchronized boolean sendEmail(String from, String to, String subject, String mailText) throws Exception {

		smtpServer = "mail.oper.cbasa-ciesa.com.ar";
		userName = "autogestionCPM@cbasa-ciesa.com.ar";
		password = "asd789hj";

		if ((to == null) && (subject == null))
			return false;
		if (mailText == null)
			mailText = "";
		if (from == null)
			from = userName;
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", smtpServer);
			// SMTP server authentication is set to false, by default. Setting
			// it to true as shown below
			props.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			// Setting the 'from', 'to', 'cc' addresses and the 'subject'
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			// Making the mail body as inline and of html type
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart text = new MimeBodyPart();
			
			
			//agregar la imanen
			BodyPart messageBodyPart = new MimeBodyPart();
			// String htmlText = "<H1>Hello</H1><img src=\"cid:image1\">";
			String htmlText = mailText;
			messageBodyPart.setContent(htmlText, "text/html");
			mp.addBodyPart(messageBodyPart);
			
			 // second part (the image)
	        messageBodyPart = new MimeBodyPart();
	        
	        
	        
	        //DataSource fds = new FileDataSource
	        //  ("C:\\1\\100156.jpg");
	        DataSource fds = new FileDataSource
	          ("C:\\1\\100156.jpg");
	        
	        //DataSource fds = null;
	        messageBodyPart.setDataHandler(new DataHandler(fds));
	        messageBodyPart.setHeader("Content-ID","<image1>");
	        
	        

	        // add it
	        mp.addBodyPart(messageBodyPart);			
			

			
			text.setDisposition(Part.INLINE);
			text.setContent(mailText, "text/html");
	//mp.addBodyPart(text);
			message.setContent(mp);
			// SMTP authentication
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpServer, userName, password);
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
			
			
			
			return true;
		} catch (Exception e) {
			System.err.println("Email could not be sent due to error: " + e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static String firstHex(int dec) {
		String numeroHex = "";
		if (dec < 16) {
			switch (dec) {
			case 10:
				numeroHex = "A";
				break;
			case 11:
				numeroHex = "B";
				break;
			case 12:
				numeroHex = "C";
				break;
			case 13:
				numeroHex = "D";
				break;
			case 14:
				numeroHex = "E";
				break;
			case 15:
				numeroHex = "F";
				break;
			default:
				numeroHex = Integer.toString(dec);
				break;
			}
			return numeroHex;
		} else {
			return "false";
		}
	}
	

}
