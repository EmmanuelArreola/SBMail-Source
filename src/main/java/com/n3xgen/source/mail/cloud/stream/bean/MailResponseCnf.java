package com.n3xgen.source.mail.cloud.stream.bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The bean that contains the response once the request is received
 * 
 * @author Jafet Malváez López
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailResponseCnf {

	Integer code;
    String message;
    LocalDateTime responseTime;
	
}
