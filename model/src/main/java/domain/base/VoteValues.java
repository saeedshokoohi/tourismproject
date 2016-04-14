package domain.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by saeed on 4/14/2016.
 */
@Entity
@Table(name = "tr_vote_values", schema = "public", catalog = "tourism")
public class VoteValues extends BaseEntity {
    private Double rate1;
    private Double rate2;
    private Double rate3;
    private Double rate4;
    private Double rate5;

    @Basic
    @Column(name = "rate1", nullable = true, precision = 0)
    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    @Basic
    @Column(name = "rate2", nullable = true, precision = 0)
    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

    @Basic
    @Column(name = "rate3", nullable = true, precision = 0)
    public Double getRate3() {
        return rate3;
    }

    public void setRate3(Double rate3) {
        this.rate3 = rate3;
    }

    @Basic
    @Column(name = "rate4", nullable = true, precision = 0)
    public Double getRate4() {
        return rate4;
    }

    public void setRate4(Double rate4) {
        this.rate4 = rate4;
    }

    @Basic
    @Column(name = "rate5", nullable = true, precision = 0)
    public Double getRate5() {
        return rate5;
    }

    public void setRate5(Double rate5) {
        this.rate5 = rate5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoteValues that = (VoteValues) o;

        if (rate1 != null ? !rate1.equals(that.rate1) : that.rate1 != null) return false;
        if (rate2 != null ? !rate2.equals(that.rate2) : that.rate2 != null) return false;
        if (rate3 != null ? !rate3.equals(that.rate3) : that.rate3 != null) return false;
        if (rate4 != null ? !rate4.equals(that.rate4) : that.rate4 != null) return false;
        if (rate5 != null ? !rate5.equals(that.rate5) : that.rate5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rate1 != null ? rate1.hashCode() : 0;
        result = 31 * result + (rate2 != null ? rate2.hashCode() : 0);
        result = 31 * result + (rate3 != null ? rate3.hashCode() : 0);
        result = 31 * result + (rate4 != null ? rate4.hashCode() : 0);
        result = 31 * result + (rate5 != null ? rate5.hashCode() : 0);
        return result;
    }
}
