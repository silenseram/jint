package com.ewmw.client.services.logs;

import com.ewmw.client.entities.Log;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LogsService {
    List<Log> getLogs(LocalDate from, LocalDate to) throws CannotGetLogsException;

    boolean saveLog(String content);
}
