package entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Study implements JPAEntity {
    @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    private String name;
    @ElementCollection
    Set<Condition> conditions=new HashSet<>();
    @ElementCollection
    Set<DCM> dcm=new HashSet<>();

    public Study() {
    }

    public Study(long id,String name) {
        this.name = name;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
    }

    public  Set<DCM> getDcm() {
        return dcm;
    }

    public void setDcm(Set<DCM> dcm) {
        this.dcm = dcm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Study study = (Study) o;

        if (id != study.id) return false;
        if (name != null ? !name.equals(study.name) : study.name != null) return false;
        if (conditions != null ? !conditions.equals(study.conditions) : study.conditions != null) return false;
        return !(dcm != null ? !dcm.equals(study.dcm) : study.dcm != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        result = 31 * result + (dcm != null ? dcm.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", conditions=" + conditions +
                ", dcm=" + dcm +
                '}';
    }
}
