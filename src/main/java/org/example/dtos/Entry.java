package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

//I have used @Data annotation from lombok library that implements getters & setters for Data object
@Data
@NoArgsConstructor
  public class Entry {
    @JsonProperty("API")
    private String aPI;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Auth")
    private String auth;
    @JsonProperty("HTTPS")
    private boolean hTTPS;
    @JsonProperty("Cors")
    private String cors;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Category")
    private String category;

    public void printEntry(){
      System.out.println(String.format("API: %s", getAPI()));
      System.out.println(String.format("Description: %s", getDescription()));
      System.out.println(String.format("Auth: %s", getAuth()));
      System.out.println(String.format("HTTPS: %s", isHTTPS()));
      System.out.println(String.format("Cors: %s", getCors()));
      System.out.println(String.format("Link: %s", getLink()));
      System.out.println(String.format("Category: %s", getCategory()));
    }

}
