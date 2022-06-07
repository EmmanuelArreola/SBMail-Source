package com.n3xgen.source.mail.cloud.stream.bean;

import java.util.List;

import lombok.Data;

/**
 * This is a bean to receive a mail request (can be more than one at time) 
 * 
 * @author Jafet Malváez López
 *
 */
@Data
public class Mail {

	private String mailFrom;
	private String mailPerson;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List<Object> attachments;
    private MailAccount mailAccount;
	
}
