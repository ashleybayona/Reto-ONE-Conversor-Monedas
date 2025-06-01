package api;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/b4a4a0eef11c534c2c7d8ec4/pair/";

    public Double convertir (String base, String target, double amount) {

        String url = URL_BASE + base + "/" + target + "/" + amount;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json =response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            double conversion_result = jsonObject.get("conversion_result")
                    .getAsDouble();

            return conversion_result;
        } catch (Exception e){
            System.out.println("Se encontro el error: " +  e.getMessage());
        }

        return null;
    }
}
