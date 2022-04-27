package dictionary;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.ArrayList;

public class Dictionary  {

    private static final String URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private static CloseableHttpResponse response;
    private static CloseableHttpClient instance;


    private static int request(String resource) {
        HttpGet httpGet = new HttpGet(URL + resource);

        instance = HttpClientBuilder.create().build();

        try {
            response = instance.execute(httpGet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getStatusLine().getStatusCode();
    }

    public static boolean isEnglishWord(String word) {
        boolean flag = false;

        int responseNumber = request(word);

        try {
            if(responseNumber == 200) {
                flag = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
