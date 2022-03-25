package com.ewmw.client.http.resposes;

import com.ewmw.client.entities.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class LogsListResponse {
    @Getter
    List<Log> logs;
}
