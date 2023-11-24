package com.jonesjalapat.blog.tradesman.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeResponse {
  private String type;
  private String name;
  private String country;
  private String state;
  private String city;
  private String contact;
  private boolean active;
  private String avatar;
  private Object resume;
}
