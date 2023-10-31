package com.jonesjalapat.blog.tradesman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradesmanResponse {
  private String responseId;
}
