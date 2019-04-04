/*
 */
package com.cleverfishsoftware.utils.messagebuillder;
    
import org.apache.logging.log4j.LogManager;
import static com.cleverfishsoftware.utils.messagebuillder.LogMessage.Level.info;


/**
 * https://howtodoinjava.com/log4j/log4j-console-appender-example/
 */
public class RunLogMessageBuilder {

    
    public static void main(String[] args) {
        
        org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(RunLogMessageBuilder.class.getName());
        String trackingId ="xyz";
        String body="aabc";
        
        new LogMessage.Builder(LOGGER, info, body)
                .addTag("trackId", trackingId)
                .log(); 

    }

}
