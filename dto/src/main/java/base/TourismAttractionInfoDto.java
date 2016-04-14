package base;

/**
 * Created by saeed on 4/14/2016.
 */
public class TourismAttractionInfoDto extends  BaseEntityDto {
    private AutherDto auther;

    public AutherDto getAuther() {
        return auther;
    }

    public void setAuther(AutherDto auther) {
        this.auther = auther;
    }
}
