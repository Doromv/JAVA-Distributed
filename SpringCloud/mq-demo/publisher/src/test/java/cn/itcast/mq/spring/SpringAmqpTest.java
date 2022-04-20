package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
