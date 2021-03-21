package ua.com.owu.relations.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"user"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    public Product(String title) {
        this.title = title;
    }

    public Product(String title, User user) {
        this.title = title;
        this.user = user;
    }
}
