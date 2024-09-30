package com.dosomedev.OtherCalendarExample;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * This class makes use of the REST API of https://www.hebcal.com.
 */
public class JewishCalendar {
    public String getJewishDate(LocalDate gregorianDate) {
        String dateString = null;
        
        // Build the HTTP request.
        URI apiUri = this.getApiUri(gregorianDate);
        // Request API JSON.
        String json = this.getJsonFromApi(apiUri);
        // Get "hdate" value.
        dateString = this.parseJsonResponse(json);

        return dateString;
    }

    private String getJsonFromApi(URI api) {
        String json = null;

        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(api)
                                         .GET()
                                         .build();

        try {
            // Send request and get response.
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check for successful response.
            if (response.statusCode() != 200) {
                System.err.println("Jewish Calendar Error: API Response Code not 200.");
            } else {
                // Get JSON response.
                json = response.body();
            }
            
        } catch (IOException | InterruptedException ex) {
            System.err.println("Jewish Calendar Error: " + ex.getMessage());
        }

        return json;
    }

    private URI getApiUri(LocalDate gregorianDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String gregorianDateString = gregorianDate.format(formatter);
        String apiUrlString = "https://www.hebcal.com/hebcal?cfg=json&v=1&F=on&start=" + gregorianDateString + "&end=" + gregorianDateString;
        URI apiUri = URI.create(apiUrlString);

        return apiUri;
    }

    private String parseJsonResponse(String json) {
        String dateString = null;
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);
            JsonNode itemsNode = rootNode.get("items").get(0);

            String hdate = itemsNode.get("hdate").asText();
            String hebrew = itemsNode.get("hebrew").asText();

            dateString = hdate + " / " + hebrew;
        } catch (JsonProcessingException e) {
            System.err.println("Jewish Calendar Error: Failed parsing JSON response.");
        }

        return dateString;
    }
}
