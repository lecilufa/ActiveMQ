package basic.durable.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class DuTopicConsumer {

	public static void main(String[] args) throws JMSException {

		String clientId = "ckk_id";
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://collyer.test.server:61616");
		Connection connection = factory.createConnection();
		connection.setClientID(clientId);
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		
		// 指定主题
		Topic topic = session.createTopic("nicolas_basic_topic");

		MessageConsumer consumer = session.createDurableSubscriber(topic,clientId);
		
		
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage tm = (TextMessage) message;
				try {
					
					System.out.println(tm.getText());
					System.out.println(tm.getStringProperty("ckk2"));
					
					System.out.println();
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
