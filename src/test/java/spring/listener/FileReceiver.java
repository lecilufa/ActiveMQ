package spring.listener;

import java.io.File;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

@Component  
public class FileReceiver implements MessageListener{  
  
    public void onMessage(Message message) {  
        try {  
        	
        	BytesMessage  m = (BytesMessage) message;
        	
        	long length = m.getBodyLength();
        	
        	byte[] data = new byte[(int) length];
        	
        	m.readBytes(data);
        	
        	FileUtils.writeByteArrayToFile(new File("C:/nicot/git/myImg123.jpg"), data);
        	
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
