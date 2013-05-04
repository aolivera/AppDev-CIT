package ie.cit.adf;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMessageListener implements MessageListener {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:client.xml");
	}

	public void onMessage(Message message) {
		System.out.println(message);
	}
}
