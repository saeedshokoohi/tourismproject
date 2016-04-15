package crowler;

import com.eyeson.crawler.dto.NearByPlacesByType;
import se.walkercrou.places.Place;

import java.util.List;

/**
 * Created by saeed on 4/15/2016.
 */
public class CrowlerData {


    private Place mainPlace;
    private List<NearByPlacesByType> nearByPlaces;

    public void setMainPlace(Place mainPlace) {
        this.mainPlace = mainPlace;
    }

    public Place getMainPlace() {
        return mainPlace;
    }

    public void setNearByPlaces(List<NearByPlacesByType> nearByPlaces) {
        this.nearByPlaces = nearByPlaces;
    }

    public List<NearByPlacesByType> getNearByPlaces() {
        return nearByPlaces;
    }


}
