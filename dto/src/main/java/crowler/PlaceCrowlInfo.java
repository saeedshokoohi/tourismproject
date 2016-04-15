package crowler;

import com.eyeson.crawler.dto.NearByPlacesByType;

/**
 * Created by saeed on 4/15/2016.
 */
public class PlaceCrowlInfo {
    private NearByPlacesByType placeInfo;
    private PlaceCrowlInfo placeCrowlerInfo;

    public void setPlaceInfo(NearByPlacesByType placeInfo) {
        this.placeInfo = placeInfo;
    }

    public NearByPlacesByType getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceCrowlerInfo(PlaceCrowlInfo placeCrowlerInfo) {
        this.placeCrowlerInfo = placeCrowlerInfo;
    }

    public PlaceCrowlInfo getPlaceCrowlerInfo() {
        return placeCrowlerInfo;
    }
}
