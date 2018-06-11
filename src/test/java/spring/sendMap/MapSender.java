package spring.sendMap;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/basic_sender.xml"})
public class MapSender {
	
	@Autowired  
	@Qualifier("jmsTopicTemplate")  
	private JmsTemplate jmsTemplate;  

	//发map，value只能是基本数据类型(包括map，list)，不能是自定义java对象
	@Test
	public void sendTopic() throws Exception {
				
		jmsTemplate.send("nicolas_map_topic", new MessageCreator() {  
            
            public Message createMessage(Session session) throws JMSException {  
            		            	
            	MapMessage message = session.createMapMessage();
        	
            	message.setObject("p1", "My Name is Eliot.");

                return message;  
            }  
        });
	}
		
}
