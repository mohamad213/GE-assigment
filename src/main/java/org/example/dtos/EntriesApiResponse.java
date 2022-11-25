package org.example.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//I have used @Data annotation from lombok library that implements getters & setters for Data object
@NoArgsConstructor
@Data
public class EntriesApiResponse {
     int count;
     List<Entry> entries;
}

