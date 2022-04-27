package mx.com.sixdelta.cloud.stream.bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailResponseCnf {

	Integer code;
    String message;
    LocalDateTime responseTime;
	
}
