package base;

import base.BaseEntityDto;

import java.util.List;

/**
 * Created by jafar on 4/14/2016.
 */
/*

 */
public class TourismAttractionDto extends BaseEntityDto {
    private CategoryDto categoryDto;
    private LocationDto locationDto;
    private String name;
    List<TourismAttractionInfoDto> tourismAttractionInfoDtoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        if(locationDto == null) {
            locationDto = new LocationDto();
        }
        this.locationDto = locationDto;
    }
    public TourismAttractionDto(String name) {

        this.name = name;
    }

    public TourismAttractionDto() {
    }

    public List<TourismAttractionInfoDto> getTourismAttractionInfoDtoList() {
        return tourismAttractionInfoDtoList;
    }

    public void setTourismAttractionInfoDtoList(List<TourismAttractionInfoDto> tourismAttractionInfoDtoList) {
        this.tourismAttractionInfoDtoList = tourismAttractionInfoDtoList;
    }
}
