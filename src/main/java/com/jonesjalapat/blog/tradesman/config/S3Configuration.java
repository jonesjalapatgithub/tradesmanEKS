package com.jonesjalapat.blog.tradesman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Configuration {

  @Bean
  @Profile("prod")
  public S3Client getProdClient() {
    return S3Client.builder()
        .credentialsProvider(InstanceProfileCredentialsProvider.create())
        .region(Region.US_EAST_2)
        .build();
  }

  @Bean
  @Profile("dev")
  public S3Client getDevClient() {
    return S3Client.builder().region(Region.US_EAST_2).build();
  }
}
