package com.ewmw.client.services.logs;

import com.ewmw.client.models.Log;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface LogsService {
    List<Log> getLogs(LocalDate from, LocalDate to) throws CannotGetLogsException;

    boolean saveLog(String content);
}
