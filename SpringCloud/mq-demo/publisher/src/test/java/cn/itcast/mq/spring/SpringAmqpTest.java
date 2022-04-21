package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-04-20-11:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSendMessageSimpleQueue(){
        String queueName="simple.queue";
        String message="hello,spring amqp!";
        rabbitTemplate.convertAndSend(queueName,message);
    }
    @Test
    public void testSendMessageWorkQueue() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            String queueName="simple.queue";
            String message="hello,message__";
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendFanoutExchange() {
        String exchangeName="doromv.fanout";
        String msg="hello,everyone";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }
    @Test
    public void testSendDirectExchange() {
        String exchangeName="doromv.direct";
        String msg="hello,red";
        rabbitTemplate.convertAndSend(exchangeName,"red",msg);
    }
    @Test
    public void testSendTopicExchange() {
        String exchangeName="doromv.topic";
        String msg="晴天";
        rabbitTemplate.convertAndSend(exchangeName,"china.weather",msg);
    }
    @Test
    public void testSendObjectQueue(){
        Map<String,Object> msg=new HashMap<>();
        msg.put("name","桥本环奈");
        msg.put("age",23);
        rabbitTemplate.convertAndSend("object.queue",msg);
    }
}
