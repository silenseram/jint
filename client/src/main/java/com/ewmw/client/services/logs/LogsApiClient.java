package com.ewmw.client.services.logs;

import com.ewmw.client.entities.Log;
import com.ewmw.client.services.ApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
public class LogsApiClient extends ApiClient implements LogsService {

    public LogsApiClient(String baseUrl, String token) {
        super(baseUrl, token);
    }

    @Override
    public List<Log> getLogs(LocalDate from, LocalDate to) throws CannotGetLogsException {
        try {
            ArrayList<String> query = new ArrayList<>();

            if (from != null)
                query.add("from=" + from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            if (to != null)
                query.add("to=" + to.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            HttpResponse<String> response = sendGet("/logs/" + "?" + String.join("&",   query));

            LogsResponse logsResponse = new ObjectMapper().readValue(response.body(), LogsResponse.class);
            return logsResponse.getLogs();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CannotGetLogsException();
        }
    }

    @Override
    public boolean saveLog(String content) {
        try {
            Log log = new Log();
            log.setContent(content);

            String body = new ObjectMapper().writeValueAsString(log);

            HttpResponse<String> response = sendPost("/logs/", body);
            int status = response.statusCode();

            if (status >= 200 && status < 300)
                return true;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    private HttpResponse<String> sendMessage(String content) throws IOException, InterruptedException {
        return this.sendPost("/api/logs");
    }

    private HttpResponse<String> sendPost(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + uri))
                .header("Authorization", token)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
