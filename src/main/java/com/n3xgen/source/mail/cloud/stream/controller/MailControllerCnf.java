package com.n3xgen.source.mail.cloud.stream.controller;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.n3xgen.source.mail.cloud.stream.bean.Mail;
import com.n3xgen.source.mail.cloud.stream.bean.MailRequestCnf;
import com.n3xgen.source.mail.cloud.stream.bean.MailResponseCnf;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This is the class that exposes a rest method to retrieve the mail request 
 * 
 * @author Jafet Malváez López
 *
 */
@Slf4j
@AllArgsConstructor
@RestController
public class MailControllerCnf {

	private StreamBridge streamBridge;
	
	//@PostMapping("/mail")
	@PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MailResponseCnf> toMailBinding(@RequestBody MailRequestCnf mailRequest) {
        log.info("Sending: {} ", mailRequest);
        assert streamBridge != null;

        // You need to set the property: spring.cloud.stream.source=mailcnf
        // This will create the 'mailcnf-out-0' binding
        streamBridge.send("mailcnf-out-0", mailRequest);
        
        return ResponseEntity.
        		accepted().
        		body(new MailResponseCnf(HttpStatus.OK.value(), "Mails processed: " + ((Collection<Mail>)mailRequest.getMails()).size(), LocalDateTime.now()));
    }
	
}
