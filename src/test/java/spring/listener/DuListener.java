package spring.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component  
public class DuListener implements MessageListener{  
  
    public void onMessage(Message message) {  
        try {  
        	
        	TextMessage m = (TextMessage) message;
        	
        	System.out.println(m.getStringProperty("du"));
        	
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
