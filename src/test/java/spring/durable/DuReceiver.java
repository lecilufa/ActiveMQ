package spring.durable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/durable/durable_receiver.xml"})
public class DuReceiver {
	
	
	@Test
	public void receiveTopic() throws Exception{
		
		System.out.println("DuReceiver接收器启动...");
		
		Thread.sleep(50000000000000L);
	}
	
	
}
