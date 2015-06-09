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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SOURCE")
    private String source;

    public Source() {
    }

    public Source(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
