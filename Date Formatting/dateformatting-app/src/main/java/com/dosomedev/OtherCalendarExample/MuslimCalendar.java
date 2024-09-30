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
 * This class makes use of the REST API of https://aladhan.com.
 */
public class MuslimCalendar {
    public String getMuslimDate(LocalDate gregorianDate) {
        String dateString = null;
        
        // Build the HTTP request.
        URI apiUri = this.getApiUri(gregorianDate);
        // Request API JSON.
        String json = this.getJsonFromApi(apiUri);
        // Get date values.
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
                System.err.println("Muslim Calendar Error: API Response Code not 200.");
            } else {
                // Get JSON response.
                json = response.body();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Muslim Calendar Error: " + ex.getMessage());
        }

        return json;
    }

    private URI getApiUri(LocalDate gregorianDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String gregorianDateString = gregorianDate.format(formatter);
        String apiUrlString = "http://api.aladhan.com/v1/gToH/" + gregorianDateString;
        URI apiUri = URI.create(apiUrlString);

        return apiUri;
    }

    private String parseJsonResponse(String json) {
        String dateString = null;
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);
            JsonNode dataNode = rootNode.get("data");
            JsonNode hijriNode = dataNode.get("hijri");
            
            String day = hijriNode.get("day").asText();
            String monthEn = hijriNode.get("month").get("en").asText();
            String monthAr = hijriNode.get("month").get("ar").asText();
            String year = hijriNode.get("year").asText();

            dateString = day + " " + monthEn + " " + year + " / " + day + " " + monthAr + " " + year;
        } catch (JsonProcessingException e) {
            System.err.println("Muslim Calendar Error: Failed parsing JSON response.");
        }

        return dateString;
    }
}
