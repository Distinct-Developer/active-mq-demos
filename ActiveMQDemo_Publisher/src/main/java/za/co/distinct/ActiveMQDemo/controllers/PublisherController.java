/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package za.co.distinct.ActiveMQDemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.distinct.activemqdemo_lib.SystemMessage;

/**
 *
 * @author Boiki Mphore
 */
@RestController
public class PublisherController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PublisherController.class);
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    private String userResponse;
    
    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage message)
    {
        try
        {
            jmsTemplate.convertAndSend("test-queue", message);
            userResponse = "Message sent: ".concat(message.toString());
            LOGGER.info(userResponse);
            return new ResponseEntity<>("Message sent.", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
