package com.sdf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ProcessorApplication {
    private static Logger LOG = LoggerFactory.getLogger(ProcessorApplication.class);

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(String message) {

        LOG.info("Transforming the message");

        return message.toUpperCase();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }
}
