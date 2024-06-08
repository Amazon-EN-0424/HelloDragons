package com.ironhack.hellodragons.repository;

import com.ironhack.hellodragons.model.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragonRepository extends JpaRepository<Dragon, Long> {
}
