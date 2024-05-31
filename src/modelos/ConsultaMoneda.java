package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
   public Moneda getInfoMonedas(String moneda) {
      Gson gson = new GsonBuilder()
              .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
              .setPrettyPrinting()
              .create();
      try {
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("https://v6.exchangerate-api.com/v6/853ef4fd7ee90ca7533c03b6/latest/" + moneda + "/"))
                 .build();
         HttpResponse<String> response = client
                 .send(request, HttpResponse.BodyHandlers.ofString());

         String json = response.body();
         return gson.fromJson(json, Moneda.class);
      } catch (IllegalArgumentException e) {
         System.out.println("Error en URI, verifique la direccion");
         System.out.println(e.getMessage());
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }
       return null;
   }

}