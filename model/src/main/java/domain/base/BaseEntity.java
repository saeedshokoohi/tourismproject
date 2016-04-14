package domain.base;

import domain.Identifiable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;

/**
 * Created by saeed on 12/12/2015.
 */
@Table(name = "base_entity", schema = "public", catalog = "rm_db")
@MappedSuperclass
public class  BaseEntity implements Identifiable<UUID> {
    protected UUID id;
    protected String name;
    @Id
    @Column(name = "id", nullable = false)
    @org.hibernate.annotations.Type(type="pg-uuid")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isIdSet() {
        return id != null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
