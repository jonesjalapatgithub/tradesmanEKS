package com.jonesjalapat.blog.tradesman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {

  @NotEmpty(message = "The type is required.")
  private String type;

  @NotEmpty(message = "The description is required.")
  private String description;
}
