package com.abcdejoji.springbaisc;

import lombok.*;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asd");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }

}
