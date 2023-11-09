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
  private String yoe;
  private String status;

  /*

    "type": "CARPENTER",
    "name": "Babu ",
    "country": "INDIA",
    "state": "KARNATAKA",
    "city": "BENGALURU",
    "contact": "9992233835",
    "active": true,
    "resume": "{\"yoe\": \"15\", \"status\": \"citizen\", \"education\": [\"Skilled Trades Diploma\"], \"experience\": [\"5 years of Plumbing Experience working for KPT group Thrissur\", \"3 years of Electrician & Plumbing experience with ESAF Thrissur\"], \"certification\": [\"Expert in Plumbing works from KAPE\"]}"
  }
     */
}
