package ua.com.owu.relations.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"products","cars"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")

    private List<Product> products = new ArrayList<>();


    @JoinTable(
            name = "user_cars",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "cars_id")}
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    public User(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
