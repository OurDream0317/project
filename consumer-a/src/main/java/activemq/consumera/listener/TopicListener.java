package activemq.consumera.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    @SendTo("out.topic")
    public String receive(String text){
        System.out.println("TopicListener: topic 收到一条信息: " + text);
        return "topic received: "+text;
    }
}
