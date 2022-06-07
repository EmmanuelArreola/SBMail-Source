package com.n3xgen.source.mail.cloud.stream.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The bean that contains the parameters of the account mail to be used
 * 
 * @author Jafet Malváez López
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailAccount {

	private String host;
	private String port;
	private String user;
	private String password;
	
}
