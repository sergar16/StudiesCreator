package entities.available.dcm;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 02.06.15.
 */
@Entity
@Table(name = "AVAILABLE_SOURCES")
public class Source implements JPAEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "SOURCE")
    private String source;

    public Source() {
    }

    public Source(String source) {
        this.source = source;
    }

    public Source(long id,String source) {
        this.source = source;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source1 = (Source) o;

        if (id != source1.id) return false;
        return !(source != null ? !source.equals(source1.source) : source1.source != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", source='" + source + '\'' +
                '}';
    }
}
