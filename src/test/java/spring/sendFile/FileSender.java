package spring.sendFile;

import java.io.File;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.io.FileUtils;
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
public class FileSender {
	
	@Autowired  
	@Qualifier("jmsTopicTemplate")  
	private JmsTemplate jmsTemplate;  

	@Test
	public void sendTopic() throws Exception {
			
		jmsTemplate.send("nicolas_file_topic", new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				BytesMessage  message = session.createBytesMessage();
				
				File file = new File("C:/nicot/myImg123.jpg");
				byte[] fileData = null;
				
				try {
					fileData = FileUtils.readFileToByteArray(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				message.writeBytes(fileData);

				return message;
			}
		});
	}
		
}
