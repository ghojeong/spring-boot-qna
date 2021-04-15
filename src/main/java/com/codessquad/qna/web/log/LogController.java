package com.codessquad.qna.web.log;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    LogRepository logRepository = new LogRepository();

    @PostMapping
    public ResponseEntity<Log> addLog(@RequestBody Log log) {
        System.out.println(">>>>>>>>>>>>>" + log);
        Log newLog = logRepository.add(log);
        return ResponseEntity.created(
                URI.create("/logs" + newLog.getId())
        ).body(newLog);
    }

    @GetMapping
    public ResponseEntity<List<Log>> getLogs() {
        return ResponseEntity.ok().body(logRepository.getLogs());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Log> getLog(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(logRepository.getLog(id));
    }
}
