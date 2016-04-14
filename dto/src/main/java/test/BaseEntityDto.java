package test;

import java.util.UUID;

/**
 * Created by saeed on 12/12/2015.
 */
public class BaseEntityDto implements Identifiable<UUID> {
    protected UUID id;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public boolean isIdSet() {
        return id != null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntityDto that = (BaseEntityDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
