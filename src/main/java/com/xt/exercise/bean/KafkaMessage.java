package com.xt.exercise.bean;

import java.io.Serializable;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/27 17:17
 * @Description:
 */
public class KafkaMessage<T> implements Serializable {
    private static final long serialVersionUID = 7458715939600096779L;
    private String messageId; // 消息唯一ID
    private Long timestamp; // 消息生成时间
    private String topic; // topic
    private T data; // 消息体

    public KafkaMessage() {
    }

    public static <P> KafkaMessage<P> builder() {
        return new KafkaMessage<P>();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public KafkaMessage messageId(String messageId) {
        this.setMessageId(messageId);
        return this;
    }

    public KafkaMessage timestamp(Long timestamp) {
        this.setTimestamp(timestamp);
        return this;
    }

    public KafkaMessage data(T data) {
        this.setData(data);
        return this;
    }

    public KafkaMessage topic(String topic) {
        this.setTopic(topic);
        return this;
    }
}
