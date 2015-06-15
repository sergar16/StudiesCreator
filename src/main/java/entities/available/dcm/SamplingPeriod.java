package entities.available.dcm;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 02.06.15.
 */
@Entity
@Table(name = "AVAILABLE_SAMPLING_PERIODS")
public class SamplingPeriod implements JPAEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    long id;
    @Column(name = "SAMPLING_PERIOD")
    String samplingPeriod;

    public SamplingPeriod() {
    }

    public SamplingPeriod(String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public SamplingPeriod(long id,String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamplingPeriod that = (SamplingPeriod) o;

        if (id != that.id) return false;
        return !(samplingPeriod != null ? !samplingPeriod.equals(that.samplingPeriod) : that.samplingPeriod != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (samplingPeriod != null ? samplingPeriod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SamplingPeriod{" +
                "id=" + id +
                ", samplingPeriod='" + samplingPeriod + '\'' +
                '}';
    }
}
