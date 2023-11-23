package com.jonesjalapat.blog.tradesman.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jonesjalapat.blog.tradesman.model.ListOfTradeResponse;
import com.jonesjalapat.blog.tradesman.model.Tradesman;
import com.jonesjalapat.blog.tradesman.service.TradesmanService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;

@RestController
@AllArgsConstructor
public class TradesmanController {

  private final TradesmanService tradesmanService;

  private final S3Client s3Client;

  /**
   * Creates an entry of Tradesman.
   *
   * @param tradesman the Tradesman Request
   * @return the response entity
   */
  @PostMapping(value = "/tradesman")
  public ResponseEntity<Long> createTradesman(@Valid @RequestBody Tradesman tradesman)
      throws JsonProcessingException {
    Long response = tradesmanService.createTradesman(tradesman);

    String bucketName = "tradesman-bucket2";

    CreateBucketRequest bucketRequest = CreateBucketRequest.builder().bucket(bucketName).build();

    s3Client.createBucket(bucketRequest);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * Gets list of Tradesman for the given trade.
   *
   * @param trade filtering tradesman based on trade type
   * @return the response entity
   */
  @GetMapping(value = "/tradesman/{trade}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ListOfTradeResponse>> getTradesman(@Valid @PathVariable String trade)
      throws JsonProcessingException {
    return ResponseEntity.status(HttpStatus.OK).body(tradesmanService.getListOfTrades(trade));
  }
}
