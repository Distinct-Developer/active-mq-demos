/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package za.co.distinct.ActiveMQDemo.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import za.co.distinct.activemqdemo_lib.SystemMessage;

/**
 *
 * @author Boiki Mphore
 */
@Component
public class MessageConsumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    
    @JmsListener(destination = "test-queue")
    public void messageListener(SystemMessage message)
    {
        LOGGER.info("Message received {}", message);
    }
}
