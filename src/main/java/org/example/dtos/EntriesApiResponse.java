package org.example.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dtos.Entry;

import java.util.List;

//I have used @Data annotation from lombok library that implements getters & setters for Data object
@NoArgsConstructor
@Data
public class ResponseBody {

     int count;
     List<Entry> entries;

}

