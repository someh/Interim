/*
Copyright (C) April 2014 Mehboub Sophian

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License along
with this program; if not, write to the Free Software Foundation, Inc.,
51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package com.interim.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import conf.ParamsSMTP;


 
public class SendMailTLS {
	 
		public SendMailTLS(String from, String nameFrom, String to, String cc, String subject, String body, String format, List<File> attachFiles) throws Exception {
			final String username = ParamsSMTP.username;
			final String password = ParamsSMTP.password;
	 
			Properties props = new Properties();
			props.put("mail.smtp.auth", ParamsSMTP.auth);
			props.put("mail.smtp.starttls.enable", ParamsSMTP.starttlsEnable);
			props.put("mail.smtp.host", ParamsSMTP.host);
			props.put("mail.smtp.port", ParamsSMTP.port);
	 
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				// from a changer
				message.setFrom(new InternetAddress(from,nameFrom));
				// to a changer
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				// cc a changer
				message.setRecipients(Message.RecipientType.CC,
						InternetAddress.parse(cc));
				
				message.setSubject(subject);
				
			    // creer le message part
		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        messageBodyPart.setContent(body, format);
				
		        // creer le multi-part
		        Multipart multipart = new MimeMultipart();
		        multipart.addBodyPart(messageBodyPart);
		 
		        // ajouter les attachments
		        if (attachFiles != null && attachFiles.size() > 0) {
		            for (File filePath : attachFiles) {
		                MimeBodyPart attachPart = new MimeBodyPart();
		 
		                try {
		                    attachPart.attachFile(filePath.getAbsoluteFile());
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
		        
		        
		 
		        // ajouter le multi-part comme le contenu d'un e-mail
		        message.setContent(multipart);
	 
				Transport.send(message);
	 
	 
			} catch (MessagingException e) {
				throw new Exception("Le message ne s'est pas envoy�");
			}
		}
 
		public SendMailTLS(String from, String nameFrom, String to, String subject, String body, String format, List<File> attachFiles) throws Exception {
			final String username = ParamsSMTP.username;
			final String password = ParamsSMTP.password;
	 
			Properties props = new Properties();
			props.put("mail.smtp.auth", ParamsSMTP.auth);
			props.put("mail.smtp.starttls.enable", ParamsSMTP.starttlsEnable);
			props.put("mail.smtp.host", ParamsSMTP.host);
			props.put("mail.smtp.port", ParamsSMTP.port);
	 
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				// from a changer
				message.setFrom(new InternetAddress(from,nameFrom));
				// to a changer
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				
				message.setSubject(subject);
				
			    // creer le message part
		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        messageBodyPart.setContent(body, format);
				
		        // creer le multi-part
		        Multipart multipart = new MimeMultipart();
		        multipart.addBodyPart(messageBodyPart);
		 
		        // ajouter les attachments
		        if (attachFiles != null && attachFiles.size() > 0) {
		            for (File filePath : attachFiles) {
		                MimeBodyPart attachPart = new MimeBodyPart();
		 
		                try {
		                    attachPart.attachFile(filePath.getAbsoluteFile());
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
		        
		        
		 
		        // ajouter le multi-part comme le contenu d'un e-mail
		        message.setContent(multipart);
	 
				Transport.send(message);
	 
			} catch (MessagingException e) {
				throw new Exception("Le message ne s'est pas envoy�");
			}
		}

}
