package com.ironhack.hellodragons.model;

import com.ironhack.hellodragons.enums.DragonColor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dragons")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DragonColor color;

    @Embedded
    @AttributeOverride(name = "size", column = @Column(name = "wings_size"))
    private DragonWings wings;

    @OneToOne(mappedBy = "dragonFriend")
    private Thargaryen thargaryenFriend;

    public Dragon(String name, DragonColor color, DragonWings wings) {
        this.name = name;
        this.color = color;
        this.wings = wings;
    }

//    @Override
//    public String toString() {
//        return "Dragon{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", color=" + color +
//                ", wings=" + wings +
//                '}';
//    }
}
