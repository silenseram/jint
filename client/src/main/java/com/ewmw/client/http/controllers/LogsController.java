package com.ewmw.client.http.controllers;

import com.ewmw.client.entities.Log;
import com.ewmw.client.http.requests.GetLogsRequest;
import com.ewmw.client.http.requests.StoreLogsRequest;
import com.ewmw.client.http.resposes.LogsListResponse;
import com.ewmw.client.http.resposes.LogsSavingResponse;
import com.ewmw.client.services.logs.CannotGetLogsException;
import com.ewmw.client.services.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/logs")
public class LogsController {

    @Autowired
    LogsService logsService;

    @PostMapping("/")
    public LogsSavingResponse store(@RequestBody @Valid StoreLogsRequest request) {
        boolean result = logsService.saveLog(request.getContent());
        String message = result ? "Log saved" : "Log not saved";

        return new LogsSavingResponse(message, result);
    }

    @GetMapping("/")
    public LogsListResponse get(
            @RequestParam("from") @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam("to") @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to)
            throws CannotGetLogsException {
        List<Log> logs = logsService.getLogs(from, to);

        return new LogsListResponse(logs);
    }

}
