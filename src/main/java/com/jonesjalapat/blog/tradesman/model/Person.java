package com.jonesjalapat.blog.tradesman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

  @NotEmpty(message = "name is required.")
  private String name;

  @NotEmpty(message = "country is required.")
  private String country;

  @NotBlank(message = "state is required")
  private String state;

  @NotBlank(message = "city is required")
  private String city;

  @NotEmpty(message = "area is required.")
  private String area;

  @NotBlank(message = "contact is required")
  private String contact;

  @NotBlank(message = "avatar is required")
  private String avatar;

  private JsonNode resume;
}
