package domain.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by saeed on 4/14/2016.
 */
@Entity
@Table(name = "tr_user", schema = "public", catalog = "tourism")
public class User extends BaseEntity{
    private Short type;
    private Double rate;

    @Basic
    @Column(name = "type", nullable = true)
    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Basic
    @Column(name = "rate", nullable = true, precision = 0)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (rate != null ? !rate.equals(user.rate) : user.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
