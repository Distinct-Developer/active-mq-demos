/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package za.co.distinct.activemqdemo_lib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;

/**
 *
 * @author Boiki Mphore
 */
public class SystemMessage implements Serializable {
    
    private String source, message;

    public SystemMessage() {
        source = "Publisher";
        message = "No message provided.";
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String objectString = "";
        try
        {
            objectString = new ObjectMapper().writeValueAsString(this);
        }
        catch (JsonProcessingException e)
        {
            System.err.println(e);
        }
        return objectString;
    }
}
