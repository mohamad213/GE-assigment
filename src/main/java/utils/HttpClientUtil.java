package utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClientUtil {

    public static OkHttpClient client = new OkHttpClient();

    public static Response sendGetRequest(String url) {
        System.out.println(String.format("calling %s Api", url));
        Request request = new Request.Builder().get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            System.out.println(String.format("response status code is %s", response.code()));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed while calling %s error %s", url, e.getMessage()));
        }
        return response;
    }

}
