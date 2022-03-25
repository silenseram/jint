package com.ewmw.client.services;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@NoArgsConstructor
public abstract class ApiClient {

    @Getter
    protected String baseUrl;

    @Getter
    protected HttpClient client;
    protected String token;

    public ApiClient(String baseUrl, String token) {
        client = HttpClient.newHttpClient();

        this.baseUrl = baseUrl;
        this.token = token;
    }

    protected HttpResponse<String> sendPost(String uri, String body) throws IOException, InterruptedException {
        return sendRequest("POST", uri, body);
    }

    protected HttpResponse<String> sendGet(String uri) throws IOException, InterruptedException {
        return sendRequest("GET", uri, "");
    }

    protected HttpResponse<String> sendRequest(String type, String uri, String body) throws IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        if (type.equals("GET"))
            builder.GET();

        if (type.equals("POST"))
            builder.POST(HttpRequest.BodyPublishers.ofString(body));

        HttpRequest request = builder
                .uri(URI.create(baseUrl + uri))
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
