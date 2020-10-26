package com.syn.geekband.chapter11;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatDemo {
    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format("At {1,time} on {1,date},there was {2} on the planet{0,number,integer}.",
                planet,new Date(),event);
        System.out.println(result);
    }
}
