package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

//I have used @Data annotation from lombok library that implements getters & setters for Data object
@Data
@NoArgsConstructor
  class Entry {

    @JsonProperty("API")
    private String aPI;
    @JsonProperty("Description")
    private String mahdi;
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

}
