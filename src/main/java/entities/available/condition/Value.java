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
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long id;
    @Column(name = "VALUE")
    String value;

    public Value() {
    }

    public Value(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Value(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
