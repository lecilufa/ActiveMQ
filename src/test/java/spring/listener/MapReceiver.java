package spring.listener;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component  
public class MapReceiver implements MessageListener{  
  
    public void onMessage(Message message) {  
        try {  
        	
        	MapMessage m = (MapMessage) message;        	
        	System.out.println(m.getObject("p1"));
        	
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
