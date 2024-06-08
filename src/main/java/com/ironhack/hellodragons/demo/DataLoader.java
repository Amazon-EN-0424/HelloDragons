package com.ironhack.hellodragons.demo;

import com.ironhack.hellodragons.enums.DragonColor;
import com.ironhack.hellodragons.model.Dragon;
import com.ironhack.hellodragons.model.DragonWings;
import com.ironhack.hellodragons.model.Thargaryen;
import com.ironhack.hellodragons.service.DragonService;
import com.ironhack.hellodragons.service.ThargaryenService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ThargaryenService thargaryenService;
    private final DragonService dragonService;

    @Override
    public void run(String... args) throws Exception {


        var dragonWings = new DragonWings(10, true);
        var redDragon = new Dragon("Vhagar", DragonColor.RED, dragonWings);
        var redDragonStored = dragonService.createDragon(redDragon);

        Thargaryen visenya = new Thargaryen("Visenya", redDragonStored);
        thargaryenService.createThargaryen(visenya);

        var allDragons = dragonService.getAllDragons();
        allDragons.forEach(System.out::println);

        var allThargaryens = thargaryenService.getAllThargaryens();
        allThargaryens.forEach(System.out::println);

    }
}
