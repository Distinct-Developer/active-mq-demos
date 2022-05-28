/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package za.co.distinct.ActiveMQDemo.configs;

import javax.jms.ConnectionFactory;
import javax.jms.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

/**
 *
 * @author Boiki Mphore
 */

@Configuration
@EnableJms
public class JmsConfig {
    
    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        jmsListenerContainerFactory.setSessionTransacted(Boolean.TRUE);
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency("5-10");
        return jmsListenerContainerFactory;
    }
}
