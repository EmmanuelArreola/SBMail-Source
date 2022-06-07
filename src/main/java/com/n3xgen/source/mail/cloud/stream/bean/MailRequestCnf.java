package com.n3xgen.source.mail.cloud.stream.bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This bean contains the request expected to start the stream
 * 
 * @author Jafet Malváez López
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailRequestCnf {

	String action;
    Iterable<Mail> mails;
    LocalDateTime created;
	
}
