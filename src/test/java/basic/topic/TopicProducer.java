package basic.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProducer {

	public static void main(String[] args) throws JMSException {
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://collyer.test.server:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		
		// 创建Topic
		Topic topic = session.createTopic("nicolas_basic_topic");
		
		MessageProducer producer = session.createProducer(topic);
		
		// NON_PERSISTENT 非持久化 PERSISTENT 持久化,发送消息时用使用持久模式
		//producer.setDeliveryMode(DeliveryMode.PERSISTENT);
				
		TextMessage message = session.createTextMessage();
		message.setText("topic 1111");
		message.setStringProperty("ckk2", "topic 2222");
		
		producer.send(message);

		session.commit();
		session.close();
		connection.close();
	}
}
