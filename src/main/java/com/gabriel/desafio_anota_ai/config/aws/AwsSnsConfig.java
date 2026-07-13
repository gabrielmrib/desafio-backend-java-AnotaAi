package com.gabriel.desafio_anota_ai.config.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class    AwsSnsConfig {
    @Value("${aws.acceskeyId}")
    private String awsAcceskey;
    @Value("${aws.secretkey}")
    private String awsSecretkey;
    @Value("${aws.region}")
    private String awsRegion;
    @Value("${aws.sns.topic.catalog.arn}")
    private String awsSnsTopicCatalogArn;

    @Bean
    public AmazonSNS amazonSNSBulder(){
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(awsAcceskey,awsSecretkey);

        return AmazonSNSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .withRegion(awsRegion).build();

    }

    @Bean(name = "catalogEventsTopic")
    public Topic snsCatalogTopicBuilder(){
        return  new Topic().withTopicArn(awsSnsTopicCatalogArn);
    }
}
