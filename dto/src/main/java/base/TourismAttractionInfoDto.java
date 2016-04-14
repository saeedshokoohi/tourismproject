package base;

import java.io.Serializable;

/**
 * Created by saeed on 4/14/2016.
 */
public class TourismAttractionInfoDto extends  BaseEntityDto {
    private String detail;
    private AutherDto auther;
    private InfoReferenceDto infoReferenceDto;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public InfoReferenceDto getInfoReferenceDto() {
        return infoReferenceDto;
    }

    public void setInfoReferenceDto(InfoReferenceDto infoReferenceDto) {
        this.infoReferenceDto = infoReferenceDto;
    }

    public AutherDto getAuther() {
        return auther;
    }

    public void setAuther(AutherDto auther) {
        this.auther = auther;
    }



}
