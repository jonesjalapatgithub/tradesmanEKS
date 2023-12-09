package com.jonesjalapat.blog.tradesman.cloud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;

@Service
@RequiredArgsConstructor
public class S3Service {

  private final S3Client s3Client;

  @Value("${bucketname}")
  private String bucketName;

  public void validateAvatar(String avatar) {
    this.exists(bucketName, avatar);
  }

  private boolean exists(String bucket, String key) {
    try {
      HeadObjectResponse headResponse =
          s3Client.headObject(HeadObjectRequest.builder().bucket(bucket).key(key).build());
      return true;
    } catch (NoSuchKeyException e) {
      throw e;
    }
  }
}
