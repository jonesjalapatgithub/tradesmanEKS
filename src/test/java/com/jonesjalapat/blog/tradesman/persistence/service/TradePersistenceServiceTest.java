package com.jonesjalapat.blog.tradesman.persistence.service;

import static org.junit.jupiter.api.Assertions.*;

import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.repository.PersonRepository;
import com.jonesjalapat.blog.tradesman.persistence.repository.TradeRepository;
import com.jonesjalapat.blog.tradesman.persistence.repository.TradesmanRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class TradePersistenceServiceTest {

  // System in Test
  TradePersistenceService tradePersistenceService;

  @Mock TradesmanRepository tradesmanRepository;
  @Mock TradeRepository tradeRepository;
  @Mock PersonRepository personRepository;

  @BeforeEach
  void setUp() {
    tradePersistenceService =
        new TradePersistenceService(tradesmanRepository, tradeRepository, personRepository);
  }

  @Test
  public void getListOfTradesOfTradeTypeCarpenter() {
    // GIVEN
    String trade = "Carpenter";
    TradeResponse tradeResponse = createTradeResponse();
    Mockito.when(tradesmanRepository.findTradesmanByTrade(trade))
        .thenReturn(Collections.singletonList(tradeResponse));
    // WHEN
    List<TradeResponse> response = tradePersistenceService.getListOfTrades(trade);
    // THEN
    Assertions.assertEquals(response.get(0).getType(), trade);
  }

  private TradeResponse createTradeResponse() {
    TradeResponse tradeResponse = new TradeResponse();
    tradeResponse.setType("Carpenter");
    return tradeResponse;
  }
}
