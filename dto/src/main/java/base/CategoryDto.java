package base;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
public class CategoryDto implements Serializable {
    private UUID id;
    private String title;

    public CategoryDto() {
    }

    public CategoryDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
