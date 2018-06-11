package basic.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

 
public class QueueProducer {
	private static String user = ActiveMQConnection.DEFAULT_USER;
	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private static String url = "tcp://collyer.test.server:61616";

	public static void main(String[] args) throws Exception {
		// ConnectionFactory ：连接工厂，JMS 用它创建Connection
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		
		// 建立Connection
		Connection connection = connectionFactory.createConnection();		
		connection.start(); // Connection 启动

		// Session： 一个发送或接收消息的线程
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		
		// Queue ：消息的目的地;消息发送给谁.
		Queue queue = session.createQueue("nicolas_basic_queue");
		
		// MessageProducer：消息发送者
		MessageProducer producer = session.createProducer(queue);
		
		// 设置不持久化，实际根据项目决定
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		sendMessage(session, producer);
		session.commit();

		connection.close();
	}

	public static void sendMessage(Session session, MessageProducer producer) throws Exception {
		TextMessage message = session.createTextMessage();
		
		message.setText("queue 333111");
		message.setStringProperty("ckk1", "queue 333");
		
		producer.send(message);
	}
}
