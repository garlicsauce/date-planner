package io.garlicsauce.dateplanner.api;

import io.garlicsauce.dateplanner.boundary.ImportantDates;
import io.garlicsauce.dateplanner.domain.ImportantDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/importantDates")
@RequiredArgsConstructor
public class ImportantDatesController {

    private final ImportantDates importantDates;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addImportantDate(@RequestBody @Valid ImportantDate importantDate) {
        importantDates.save(importantDate);
    }
}
