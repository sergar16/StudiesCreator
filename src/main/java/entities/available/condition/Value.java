package entities.available.condition;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 08.06.15.
 */
@Embeddable
@Table(name = "AVAILABLE_VALUES")
public class Value{
    @Column(name = "VALUE")
    String value;

    public Value() {
    }

    public Value( String value) {

        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
