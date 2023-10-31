package com.jonesjalapat.blog.tradesman.controller;

import com.jonesjalapat.blog.tradesman.model.Tradesman;
import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.service.TradesmanService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TradesmanController {

  private final TradesmanService tradesmanService;

  /**
   * Creates an entry of Tradesman.
   *
   * @param tradesman the Tradesman Request
   * @return the response entity
   */
  @PostMapping(value = "/tradesman")
  public ResponseEntity<Long> createTradesman(@Valid @RequestBody Tradesman tradesman) {
    Long response = tradesmanService.createTradesman(tradesman);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * Gets list of Tradesman for the given trade.
   *
   * @param trade filtering tradesman based on trade type
   * @return the response entity
   */
  @GetMapping(value = "/tradesman/{trade}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TradeResponse>> getTradesman(@Valid @PathVariable String trade) {
    return ResponseEntity.status(HttpStatus.OK).body(tradesmanService.getListOfTrades(trade));
  }
}
