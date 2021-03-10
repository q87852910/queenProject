package com.kafka;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
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
        //Q 为什么kafka的key和value做序列化,为什么要序列化？
        //A:因为kafka broker在接受消息时候，必须要以二进制方式接受，所以必须序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //1.配置生成者启动的关键属性参数
        //2.创建kafka生成者对象，传递properties属性参数集合
        //key是kafka用于做消息投递具体投递到对应的主题的哪一个pratition而需要的
        //value 实际发送消息的内容
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(properties);
        User user=new User("001","张三");
        ProducerRecord<String,String> record=
                //topic  发送到的主题,实际的消息体内容
                new ProducerRecord<String,String>("test-quickstart", JSON.toJSONString(user));

        //3.构造消息内容
        //4.发送消息
        producer.send(record);
        producer.close();

    }
}
