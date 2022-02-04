package com.example.ebook;

import org.apache.juli.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EbookApplication {

    private static final Logger LOG = LoggerFactory.getLogger(EbookApplication.class);

    public static void main(String[] args) {
        System.out.println("running");
//        SpringApplication.run(EbookApplication.class, args);

        SpringApplication app = new SpringApplication(EbookApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("successfully started!");

    }

}