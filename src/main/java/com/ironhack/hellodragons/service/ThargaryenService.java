package com.ironhack.hellodragons.service;

import com.ironhack.hellodragons.model.Thargaryen;
import com.ironhack.hellodragons.repository.ThargaryenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThargaryenService {

    private final ThargaryenRepository thargaryenRepository;

    public Thargaryen createThargaryen(Thargaryen thargaryen) {
        log.info("Creating thargaryen: {}", thargaryen);
        return thargaryenRepository.save(thargaryen);
    }

    public Optional<Thargaryen> getThargaryenById(Long id) {
        log.info("Getting thargaryen with id: {}", id);
        var thargaryenRetrieved = thargaryenRepository.findById(id);
        if (thargaryenRetrieved.isEmpty()) {
            log.warn("Thargaryen with id {} not found", id);
        }
        return thargaryenRetrieved;
    }

    public List<Thargaryen> getAllThargaryens() {
        log.info("Getting all thargaryens");
        return thargaryenRepository.findAll();
    }
}
