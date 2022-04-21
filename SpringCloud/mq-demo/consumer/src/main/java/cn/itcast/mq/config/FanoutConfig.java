package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Doromv
 * @create 2022-04-21-9:04
 */
@Configuration
public class FanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("doromv.fanout");
    }
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }
}
