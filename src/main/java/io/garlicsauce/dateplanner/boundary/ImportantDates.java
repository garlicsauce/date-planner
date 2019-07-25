package io.garlicsauce.dateplanner.boundary;

import io.garlicsauce.dateplanner.domain.ImportantDate;
import io.garlicsauce.dateplanner.domain.ImportantDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportantDates {

    private final ImportantDateRepository importantDateRepository;

    public void save(ImportantDate importantDate) {
        importantDateRepository.save(importantDate);
    }
}
