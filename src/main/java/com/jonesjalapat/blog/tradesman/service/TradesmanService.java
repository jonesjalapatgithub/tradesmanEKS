package com.jonesjalapat.blog.tradesman.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jonesjalapat.blog.tradesman.model.ListOfTradeResponse;
import com.jonesjalapat.blog.tradesman.model.Tradesman;
import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.service.TradePersistenceService;
import com.jonesjalapat.blog.tradesman.util.ResponseMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TradesmanService {

  private final TradePersistenceService tradePersistenceService;

  private final ResponseMapper responseMapper;

  public Long createTradesman(Tradesman tradesman) throws JsonProcessingException {
    return tradePersistenceService.createTradesman(tradesman);
  }

  public List<ListOfTradeResponse> getListOfTrades(String trade) throws JsonProcessingException {
    List<TradeResponse> tradeResponses = tradePersistenceService.getListOfTrades(trade);
    return responseMapper.mapResponse(tradeResponses);
  }
}