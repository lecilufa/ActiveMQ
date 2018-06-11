package spring.basic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

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
public class Sender {
	
	@Autowired  
	@Qualifier("jmsTopicTemplate")  //这个jmsTemplate只能发topic   要发queue用另一个jmsTemplate， 具体看spring配置文件
	private JmsTemplate jmsTemplate;  

	/**
	 * 最基本的例子  发送String信息
	 * @throws Exception
	 */
	@Test
	public void sendTopic() throws Exception {
				
		
		jmsTemplate.send("nicolas_basic_topic", new MessageCreator() {  
            
            public Message createMessage(Session session) throws JMSException {  
            		            	
            	TextMessage message = session.createTextMessage();
            	
            	message.setStringProperty("c1", "this is c1 channel Speaking. 222 ");
            	
                return message;  
            }  
        });
	}
		
}
