package services;

import base.CategoryDto;
import base.LocationDto;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by peyman on 4/14/2016.
 */
@Named
public class LocationService implements Serializable {
    List<LocationDto> locationDtoList = new ArrayList<LocationDto>();

    public List<LocationDto> getLocationDtoList() {
        return locationDtoList;
    }

    public void setLocationDtoList(List<LocationDto> locationDtoList) {
        this.locationDtoList = locationDtoList;
    }

    @PostConstruct
    public void generateLocationList() {
        List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
        LocationDto locationDto = new LocationDto("تهران");
        locationDtoList.add(locationDto);
        locationDto = new LocationDto("اصفهان");
        locationDtoList.add(locationDto);
        locationDto = new LocationDto("ایلام");
        locationDtoList.add(locationDto);
        locationDto = new LocationDto("تبریز");
        locationDtoList.add(locationDto);
        locationDto = new LocationDto("کرمان");
        locationDtoList.add(locationDto);
        setLocationDtoList(locationDtoList);
    }

    public List<LocationDto> locationDtoComplete(String query) {
        List<LocationDto> returnLocationDto = new ArrayList<LocationDto>();
        for (LocationDto locationDto :getLocationDtoList()) {
            if (locationDto.getName().contains(query)) {
                returnLocationDto.add(locationDto);
            }
        }
        return returnLocationDto;
    }

}
