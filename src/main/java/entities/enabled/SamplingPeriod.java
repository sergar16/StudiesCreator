package entities.enabled;

import entities.JPAEntity;

import javax.persistence.*;

/**
 * Created by Logitech on 02.06.15.
 */
@Entity
@Table(name = "SAMPLING_PERIODS")
public class SamplingPeriod implements JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    String id;
    @Column(name = "SAMPLING_PERIOD")
    String samplingPeriod;

    public SamplingPeriod() {
    }

    public SamplingPeriod(String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }
}
