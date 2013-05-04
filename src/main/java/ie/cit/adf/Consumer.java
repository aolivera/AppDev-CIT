package ie.cit.adf;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Consumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:beans.xml");

		JmsTemplate jmsTemplate = new JmsTemplate(
				ctx.getBean(ConnectionFactory.class));
		
		Queue queue = ctx.getBean("queue", Queue.class);
		
		Message message = jmsTemplate.receive(queue);
		System.out.println(message);
		
	}
}