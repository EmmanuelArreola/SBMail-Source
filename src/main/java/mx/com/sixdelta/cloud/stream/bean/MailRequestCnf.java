package mx.com.sixdelta.cloud.stream.bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailRequestCnf {

	String action;
    Iterable<Mail> mails;
    LocalDateTime created;
	
}
