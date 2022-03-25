package com.ewmw.client.http.responses;

import com.ewmw.client.models.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class LogsListResponse {
    @Getter
    List<Log> logs;
}
