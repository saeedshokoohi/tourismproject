package base;

/**
 * Created by jafar on 4/14/2016.
 */

/**
 * the place or location where TourismAtrraction
 * is located
 */
public class LocationDto extends BaseEntityDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
