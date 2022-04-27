package mx.com.sixdelta.cloud.stream.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailAccount {

	private String host;
	private String port;
	private String user;
	private String password;
	
}
