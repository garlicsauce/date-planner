package io.garlicsauce.dateplanner.infrastructure;

import io.garlicsauce.dateplanner.domain.ImportantDate;
import io.garlicsauce.dateplanner.domain.ImportantDateRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryImportantDateRepository implements ImportantDateRepository {

    private final Map<UUID, ImportantDate> repository = new ConcurrentHashMap<>();

    @Override
    public synchronized ImportantDate save(ImportantDate importantDate) {
        importantDate.setId(UUID.randomUUID());
        repository.put(importantDate.getId(), importantDate);

        return importantDate;
    }
}
