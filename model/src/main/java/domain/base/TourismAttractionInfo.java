package domain.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by saeed on 4/14/2016.
 */
@Entity
@Table(name = "tr_tourism_attraction_info", schema = "public", catalog = "tourism")
public class TourismAttractionInfo extends BaseEntity{
    private String description;

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourismAttractionInfo that = (TourismAttractionInfo) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
