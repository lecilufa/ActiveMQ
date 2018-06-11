package spring.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Component;

@Component  
public class ObjectReceiver implements MessageListener{  
  
    public void onMessage(Message message) {  
        try {  
        	
        	ObjectMessage m = (ObjectMessage) message;        	
        	System.out.println(m.getObject());
        	
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
