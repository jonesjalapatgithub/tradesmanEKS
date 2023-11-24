package com.jonesjalapat.blog.tradesman.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonesjalapat.blog.tradesman.model.ListOfTradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

  @Value("${bucketname}")
  private String bucketName;

  @Value("${region}")
  private String region;

  public List<ListOfTradeResponse> mapResponse(List<TradeResponse> tradeResponses)
      throws JsonProcessingException {
    List<ListOfTradeResponse> listOfTradeResponses = new ArrayList<>();
    for (TradeResponse tradesFromDB : tradeResponses) {
      ListOfTradeResponse tradeResponse = new ListOfTradeResponse();
      tradeResponse.setActive(tradesFromDB.isActive());
      tradeResponse.setName(tradesFromDB.getName());
      tradeResponse.setCity(tradesFromDB.getCity());
      tradeResponse.setState(tradesFromDB.getState());
      tradeResponse.setCountry(tradesFromDB.getCountry());
      tradeResponse.setContact(tradesFromDB.getContact());
      tradeResponse.setType(tradesFromDB.getType());
      setAvatar(tradeResponse, tradesFromDB.getAvatar());
      listOfTradeResponses.add(tradeResponse);
      ObjectMapper objectMapper = new ObjectMapper();
      Object object = tradesFromDB.getResume();
      JsonNode jsonNode = objectMapper.readTree(object.toString());
      String yoe = jsonNode.get("yoe") != null ? jsonNode.get("yoe").asText() : "";
      String status = jsonNode.get("yoe") != null ? jsonNode.get("status").asText() : "";
      tradeResponse.setYoe(yoe);
      tradeResponse.setStatus(status);
    }
    return listOfTradeResponses;
  }

  private void setAvatar(ListOfTradeResponse tradeResponse, String avatar) {
    String url = "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + avatar;
    tradeResponse.setAvatar(url);
  }
}
