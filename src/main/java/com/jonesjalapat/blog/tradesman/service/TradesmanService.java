package com.jonesjalapat.blog.tradesman.service;

import com.jonesjalapat.blog.tradesman.model.Tradesman;
import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.service.TradePersistenceService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TradesmanService {

  private final TradePersistenceService tradePersistenceService;

  public Long createTradesman(Tradesman tradesman) {
    return tradePersistenceService.createTradesman(tradesman);
  }

  public List<TradeResponse> getListOfTrades(String trade) {
    return tradePersistenceService.getListOfTrades(trade);
  }
}
