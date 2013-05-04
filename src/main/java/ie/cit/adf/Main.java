package ie.cit.adf;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:beans.xml");

		JmsTemplate jmsTemplate = new JmsTemplate(
				ctx.getBean(ConnectionFactory.class));

		Topic topic = ctx.getBean("topic", Topic.class);

		jmsTemplate.send(topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello World!");
			}
		});
	}

}
