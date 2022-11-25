package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.example.dtos.EntriesApiResponse;
import org.example.dtos.Entry;
import utils.HttpClientUtil;

import java.util.List;

public class EntriesApi {

    static final String ApiUrl = "https://api.publicapis.org/entries";
    static ObjectMapper mapper = new ObjectMapper();

    public static List<Entry> callEntriesAPiAndGetListOfEntries() throws Exception {
        Response response = HttpClientUtil.sendGetRequest(ApiUrl);

        EntriesApiResponse responseBody;
        try {
            responseBody = mapper.readValue(response.body().string(), EntriesApiResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(String.format("Failed while parsing entries json, error %s", e.getMessage()));
        }
        return responseBody.getEntries();
    }
}
