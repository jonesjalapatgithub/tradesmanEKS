package com.jonesjalapat.blog.tradesman.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Configuration {

  @Value("${region}")
  private String region;

  @Bean
  @Profile("prod")
  public S3Client getProdClient() {
    return S3Client.builder()
        .credentialsProvider(InstanceProfileCredentialsProvider.create())
        .region(Region.of(region))
        .build();
  }

  @Bean
  @Profile("dev")
  public S3Client getDevClient() {
    return S3Client.builder().region(Region.of(region)).build();
  }
}
