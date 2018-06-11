package basic.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class QueueConsumer {
	private static String user = ActiveMQConnection.DEFAULT_USER;
	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private static String url = "tcp://collyer.test.server:61616";

	public static void main(String[] args) throws Exception {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

		Connection connection = connectionFactory.createConnection();
		connection.start();

		final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

		Queue queue = session.createQueue("nicolas_basic_queue");

		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {					
					TextMessage textMessage = (TextMessage) message;
					
					System.out.println(textMessage.getText());
					System.out.println(textMessage.getStringProperty("ckk1"));
					
					System.out.println();		
					
					session.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});

		/*
		 * 另外一种接受方式 while (true) { //设置接收者接收消息的时间，为了便于测试，这里谁定为100s TextMessage
		 * message = (TextMessage) consumer.receive(100000); if (null !=
		 * message) { System.out.println("收到消息" + message.getText()); } else {
		 * break; } }
		 */
	}
}
