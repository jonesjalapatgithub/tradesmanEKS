package com.jonesjalapat.blog.tradesman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfTradeResponse {

  private String type;
  private String name;
  private String country;
  private String state;
  private String city;
  private String contact;
  private boolean active;
  private String avatar;
  private String yoe;
  private String status;
}
