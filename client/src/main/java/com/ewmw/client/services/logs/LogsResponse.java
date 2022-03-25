package com.ewmw.client.services.logs;

import com.ewmw.client.entities.Log;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LogsResponse {
    @Getter @Setter
    protected List<Log> logs;
}
