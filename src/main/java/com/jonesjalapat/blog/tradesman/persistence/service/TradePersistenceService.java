package com.jonesjalapat.blog.tradesman.persistence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonesjalapat.blog.tradesman.model.Tradesman;
import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.entity.PersonEntity;
import com.jonesjalapat.blog.tradesman.persistence.entity.TradeEntity;
import com.jonesjalapat.blog.tradesman.persistence.entity.TradesmanEntity;
import com.jonesjalapat.blog.tradesman.persistence.repository.PersonRepository;
import com.jonesjalapat.blog.tradesman.persistence.repository.TradeRepository;
import com.jonesjalapat.blog.tradesman.persistence.repository.TradesmanRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TradePersistenceService {

  private final TradesmanRepository tradesmanRepository;
  private final TradeRepository tradeRepository;
  private final PersonRepository personRepository;

  @Transactional()
  public Long createTradesman(Tradesman tradesman) throws JsonProcessingException {
    String[] trades = tradesman.getTrade();
    List<TradesmanEntity> tradesmanEntities = new ArrayList<>();
    PersonEntity personEntity = createPersonEntity(tradesman);
    personRepository.save(personEntity);
    for (String trade : trades) {
      TradeEntity tradeEntity = tradeRepository.findByType(trade);
      TradesmanEntity tradesmanEntity = new TradesmanEntity();
      tradesmanEntity.setPersonEntity(personEntity);
      tradesmanEntity.setTradeEntity(tradeEntity);
      tradesmanEntities.add(tradesmanEntity);
    }
    List<TradesmanEntity> response = tradesmanRepository.saveAll(tradesmanEntities);
    return response.get(0).getPersonEntity().getId();
  }

  private PersonEntity createPersonEntity(Tradesman tradesman) throws JsonProcessingException {
    PersonEntity personEntity = new PersonEntity();
    personEntity.setCity(tradesman.getPerson().getCity());
    personEntity.setContact(tradesman.getPerson().getContact());
    personEntity.setState(tradesman.getPerson().getState());
    personEntity.setCountry(tradesman.getPerson().getCountry());
    personEntity.setName(tradesman.getPerson().getName());
    personEntity.setActive(true);
    personEntity.setArea(tradesman.getPerson().getArea());
    JsonNode resumeFields = tradesman.getPerson().getResume();
    if (resumeFields != null) {
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(resumeFields);
      personEntity.setResume(json);
    }
    return personEntity;
  }

  public List<TradeResponse> getListOfTrades(String trade) {
    return tradesmanRepository.findTradesmanByTrade(trade);
  }
}
