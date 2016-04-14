package domain.base;

import javax.persistence.*;

/**
 * Created by saeed on 4/14/2016.
 */
@Entity
@Table(name = "tr_info_reference", schema = "public", catalog = "tourism")
public class InfoReference extends BaseEntity{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoReference that = (InfoReference) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
