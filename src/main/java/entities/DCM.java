package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Logitech on 02.06.15.
 */
@Embeddable
public class DCM implements Serializable{

    @JsonIgnore
    String id;

    @Column(name = "KEY")
    String key;
    @Column(name = "SOURCE")
    String source;
    @Column(name = "SAMPLING_PERIOD")
    String samplingPeriod;



    public DCM(String key, String source, String samplingPeriod) {
        this.key = key;
        this.source = source;
        this.samplingPeriod = samplingPeriod;
    }

    public DCM() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(String samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
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

        DCM dcm = (DCM) o;

        if (key != null ? !key.equals(dcm.key) : dcm.key != null) return false;
        if (source != null ? !source.equals(dcm.source) : dcm.source != null) return false;
        if (samplingPeriod != null ? !samplingPeriod.equals(dcm.samplingPeriod) : dcm.samplingPeriod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (samplingPeriod != null ? samplingPeriod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DCM{" +
                "key='" + key + '\'' +
                ", source='" + source + '\'' +
                ", samplingPeriod='" + samplingPeriod + '\'' +
                '}';
    }
}
