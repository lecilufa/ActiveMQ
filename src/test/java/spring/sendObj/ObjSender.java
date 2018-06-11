package spring.sendObj;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.model.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/basic_sender.xml"})
public class ObjSender {
	
	@Autowired  
	@Qualifier("jmsTopicTemplate")  
	private JmsTemplate jmsTemplate;  

	@Test
	public void sendTopic() throws Exception {
				
		jmsTemplate.send("nicolas_object_topic", new MessageCreator() {  
            
            public Message createMessage(Session session) throws JMSException {  
            		            	
            	ObjectMessage message = session.createObjectMessage();
            	
            	Person person = new Person("Eliot","male");           	
            	message.setObject( person);

                return message;  
            }  
        });
	}
		
}
