package entities.enabled;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 02.06.15.
 */
@Entity
@Table(name = "ENABLED_KEYS")
public class Key implements JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    String id;
    @Column
    String keyValue;

    public Key() {
    }

    public Key(String key) {
        this.keyValue = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
