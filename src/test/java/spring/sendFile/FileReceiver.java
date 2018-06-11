package spring.sendFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/sendFile/file_receiver.xml"})
public class FileReceiver {
	
	
	@Test
	public void receiveTopic() throws Exception{
		
		System.out.println("FileReceiver接收器启动...");
		
		Thread.sleep(50000000000000L);
	}
	
	
}
