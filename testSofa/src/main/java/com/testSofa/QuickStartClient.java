package com.testSofa;

import com.alipay.sofa.rpc.config.ConsumerConfig;

public class QuickStartClient {
    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:12200"); // 指定直连地址

        HelloService helloService = consumerConfig.refer();
        int i=1;
        while (i<=20) {
            System.out.println(helloService.sayHello("world"));
            i++;
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}