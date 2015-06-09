package entities.available.condition;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 08.06.15.
 */
@Entity
@Table(name = "AVAILABLE_VALUES")
public class Value  implements JPAEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column(name = "VALUE")
    String value;

    public Value() {
    }

    public Value(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
