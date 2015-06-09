package entities.available.dcm;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 02.06.15.
 */
@Entity
@Table(name = "AVAILABLE_KEYS")
public class Key implements JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "VALUE")
    String keyValue;

    public Key() {
    }

    public Key(String key) {
        this.keyValue = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String key) {
        this.keyValue = key;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (id != null ? !id.equals(key.id) : key.id != null) return false;
        return !(keyValue != null ? !keyValue.equals(key.keyValue) : key.keyValue != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (keyValue != null ? keyValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id='" + id + '\'' +
                ", keyValue='" + keyValue + '\'' +
                '}';
    }
}
