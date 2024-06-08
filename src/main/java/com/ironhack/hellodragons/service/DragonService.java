package com.ironhack.hellodragons.service;

import com.ironhack.hellodragons.model.Dragon;
import com.ironhack.hellodragons.repository.DragonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DragonService {

    //    No need to autowire the repository, we can use constructor injection.
//    Remember to use final keyword and @RequiredArgsConstructor
    private final DragonRepository dragonRepository;


    public Dragon createDragon(Dragon dragon) {
        log.info("Creating dragon: {}", dragon);
        return dragonRepository.save(dragon);
    }

    public Optional<Dragon> getDragonById(Long id) {
        log.info("Getting dragon with id: {}", id);
        var dragonRetrieved = dragonRepository.findById(id);
        if (dragonRetrieved.isEmpty()) {
            log.warn("Dragon with id {} not found", id);
        }
        return dragonRetrieved;
    }

    public List<Dragon> getAllDragons() {
        log.info("Getting all dragons");
        return dragonRepository.findAll();
    }

}
