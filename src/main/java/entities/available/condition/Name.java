package entities.available.condition;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 08.06.15.
 */
@Entity
@Table(name = "AVAILABLE_NAMES")
public class Name implements JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column
    String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Long getId() {
        return id;
    }


}
