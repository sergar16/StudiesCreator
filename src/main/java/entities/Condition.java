package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Logitech on 02.06.15.
 */
@Embeddable
public class Condition implements Serializable {


    @JsonIgnore
    String id;
    String name;
    String value;

    public Condition(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Condition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (name != null ? !name.equals(condition.name) : condition.name != null) return false;
        return !(value != null ? !value.equals(condition.value) : condition.value != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
