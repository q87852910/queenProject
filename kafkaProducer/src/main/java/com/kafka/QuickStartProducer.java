package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class QuickStartProducer {
    public static void main(String[] args) {
        Properties properties=new Properties();
        //1.1连接kafka集群服务列表
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"123.57.68.235:9092");
        //1.2标记kafkaClient-Id
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"quickstart-producer");
        //1.3 对kafka的key和value做序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //1.配置生成者启动的关键属性参数
        //2.创建kafka生成者对象，传递properties属性参数集合
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(properties);
        //3.构造消息内容
        //4.发送消息

    }
}
