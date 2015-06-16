package entities.available.condition;

import entities.JPAEntity;
import entities.available.dcm.Key;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by Logitech on 08.06.15.
 */
@Entity
@Table(name = "AVAILABLE_NAMES")
public class Name implements JPAEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }


    public void setId(long id) {
        this.id = id;
    }

    public Name(long id, String name) {
        this.id = id;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        if (id != name1.id) return false;
        return !(name != null ? !name.equals(name1.name) : name1.name != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
