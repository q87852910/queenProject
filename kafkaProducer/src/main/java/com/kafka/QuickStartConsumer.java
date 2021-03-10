package com.kafka;

import kafka.Kafka;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class QuickStartConsumer {
    public static void main(String[] args) {
        Properties properties=new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"123.57.68.235:9092");
        //反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        //非常重要的属性:与我们消费者订阅组有关系
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"quickstart-group");
        //常规属性
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,5000);
        //消费者提交offset : 自动提交 &手工提交，默认自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,5000);

        //创建消费者对象
        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(properties);
        //订阅主题
        consumer.subscribe(Collections.singletonList("test-quickstart"));
        //采取拉取的方式消费数据
        while(true){
            //等待多久拉取消息
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            //topic和partition 是一对多的关系
            //因为消息是在partition里面存储的
            for(TopicPartition partition:records.partitions()){

            }
        }
    }
}
