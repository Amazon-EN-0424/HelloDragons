package com.ironhack.hellodragons.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "thargaryens")
public class Thargaryen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Dragon dragonFriend;

    public Thargaryen(String name, Dragon dragonFriend) {
        this.name = name;
        this.dragonFriend = dragonFriend;
    }

    @Override
    public String toString() {
        return "Thargaryen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
