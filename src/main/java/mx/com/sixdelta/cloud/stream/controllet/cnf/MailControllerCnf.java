package mx.com.sixdelta.cloud.stream.controllet.cnf;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.sixdelta.cloud.stream.bean.MailRequestCnf;
import mx.com.sixdelta.cloud.stream.bean.MailResponseCnf;

@Slf4j
@AllArgsConstructor
@RestController
public class MailControllerCnf {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MailControllerCnf.class);
	private StreamBridge streamBridge;
	
	@PostMapping("/mail")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MailResponseCnf> toMailBinding(@RequestBody MailRequestCnf mailRequest) {
        log.info("Sending: {} ", mailRequest);
        assert streamBridge != null;

        // You need to set the property: spring.cloud.stream.source=mailcnf
        // This will create the 'mailcnf-out-0' binding
        streamBridge.send("mailcnf-out-0", mailRequest);
        
        return ResponseEntity.
        		accepted().
        		body(new MailResponseCnf(HttpStatus.OK.value(), "Mails processed: " + ((Collection)mailRequest.getMails()).size(), LocalDateTime.now()));
    }
	
}
