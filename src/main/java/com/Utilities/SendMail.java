package com.Utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

public class SendMail {

	@Test
	public static void SendEmail() {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D:\\Selenium\\Codes\\FreeCRM\\test-output\\FreeCRMExtentReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("FreeCRMEntentReport");
		attachment.setName("FreeCRMExtentReport.html");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nilofer.mansuri21@gmail.com", "9821012009"));
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		try {
			email.addTo("shanawaz.mansuri@gmail.com", "Shanawaz TestLead");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			email.setFrom("nilofer.mansuri21@gmail.com", "Shanawaz Mansuri");
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		email.setSubject("Test Report");
		try {
			email.setMsg("Kindly find attached CRMTest Report for Login Page");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add the attachment
		try {
			email.attach(attachment);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// send the email
		try {
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
