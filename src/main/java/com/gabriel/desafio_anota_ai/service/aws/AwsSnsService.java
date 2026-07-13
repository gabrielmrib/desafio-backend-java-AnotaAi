package com.gabriel.desafio_anota_ai.service.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {
    private AmazonSNS snsClient;
    private Topic catalogTopic;


    public AwsSnsService(AmazonSNS snsClient,@Qualifier("catalogEventsTopic") Topic topic){
        this.snsClient = snsClient;
        this.catalogTopic = topic;

    }

    public void publis(MessageDTO message){
        this.snsClient.publish(this.catalogTopic.getTopicArn(),message.message());



    }
}
