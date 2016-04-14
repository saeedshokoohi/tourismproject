package domain.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by saeed on 4/14/2016.
 */
@Entity
@Table(name = "tr_tourism_attraction", schema = "public", catalog = "tourism")
public class TourismAttraction extends BaseEntity{
    private Short attractionType;

    @Basic
    @Column(name = "attraction_type", nullable = true)
    public Short getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(Short attractionType) {
        this.attractionType = attractionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourismAttraction that = (TourismAttraction) o;

        if (attractionType != null ? !attractionType.equals(that.attractionType) : that.attractionType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return attractionType != null ? attractionType.hashCode() : 0;
    }
}
