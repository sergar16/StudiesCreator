package entities;



import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({@NamedQuery(name = "Study.findAll", query = "SELECT s FROM Study s")})
public class Study implements JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ElementCollection
    Set<Condition> conditions=new HashSet<>();
    @ElementCollection
    Set<DCM> dcm=new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
