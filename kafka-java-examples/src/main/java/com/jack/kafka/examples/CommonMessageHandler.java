package com.jack.kafka.examples;

/**
 * Created by jack on 4/14/16.
 */
public class CommonMessageHandler implements MessageHandler<String, String> {
    public String name;
    public CommonMessageHandler(String name) {
        this.name=name;
    }
    public boolean handle(String key, String message) {
        System.out.println("CommonMessageHandler "+name+" handling -------- ["+message+"] --------");
        return true;
    }
}
