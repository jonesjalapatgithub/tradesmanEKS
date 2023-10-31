package com.jonesjalapat.blog.tradesman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tradesman {

  @NotEmpty(message = "The tradeIds are required.")
  private String[] trade;

  @NotEmpty(message = "The addressId is required.")
  private Person person;
}
