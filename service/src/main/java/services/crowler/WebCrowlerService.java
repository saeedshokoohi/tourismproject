package services.crowler;

import base.CategoryDto;
import base.LocationDto;
import com.eyeson.crawler.dto.NearByPlacesByType;
import com.eyeson.crawler.dto.PlaceSearchResult;
import com.eyeson.crawler.dto.WikipediaInfo;
import com.eyeson.crawler.handler.GMapHandler;
import com.eyeson.crawler.handler.WikipediaHandler;
import crowler.CrowlerData;
import crowler.PlaceCrowlInfo;
import se.walkercrou.places.Place;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by saeed on 4/15/2016.
 */
@Named
public class WebCrowlerService implements Serializable {


    public CrowlerData findData(LocationDto location, List<CategoryDto> categories, int maxResult,double radiusInMeter,boolean fetchWebInfoNow)
    {
        CrowlerData retCrowlerData=new CrowlerData();
        String server_apiKey = "AIzaSyD6eI4XRgN-IZi1aZ_nX_WBxdoRPatMoCk";

        String cityName=location.getName();


        GMapHandler gMapHandler = new GMapHandler(server_apiKey);

        String[] place_types = convertToplaceTypeArray(categories);

        PlaceSearchResult placeSearchResult = gMapHandler.researchOnCityByName(cityName, place_types, radiusInMeter, maxResult);
        retCrowlerData.setMainPlace(placeSearchResult.getMainPlace());
        List<NearByPlacesByType> nearByPlaces = placeSearchResult.getNearByPlaces();
        if(nearByPlaces!=null)
            for(NearByPlacesByType place:nearByPlaces)
            {
                PlaceCrowlInfo placeCrowlInfo=new PlaceCrowlInfo();
               placeCrowlInfo.setPlaceInfo(place);
                if(fetchWebInfoNow)
                {

                    placeCrowlInfo.setPlaceCrowlerInfo(getWebCrowlerDataByPlace(place));
                }

            }
         retCrowlerData.setNearByPlaces(nearByPlaces);

        return retCrowlerData;

    }

    public String getWikiDataByPlaceName(String placeName)
    {
        try {
            WikipediaHandler wikipediaHandler = new WikipediaHandler();
            WikipediaInfo data = wikipediaHandler.searchInFaWikipedia(placeName);
            String title = data.getMainTitle() + " " + data.getSummary();
            return title;
        }catch (Exception ex)
        {
            return "no wiki data!";
        }
    }
    private PlaceCrowlInfo getWebCrowlerDataByPlace(NearByPlacesByType place) {
//        WikipediaHandler wikipediaHandler=new WikipediaHandler();
//        if(place.getPlaces()!=null)
//        for(Place p: place.getPlaces() ) {
//            wikipediaHandler.searchInFaWikipedia(place.getPlaces())
//        }

        return null;
    }

    /**
     * convert list of categories to string array
     * @param categories
     * @return
     */
    private String[] convertToplaceTypeArray(List<CategoryDto> categories) {
        String[] place_types = {"restaurant", "museum", "amusement_park", "mosque", "park"};
        return  place_types;
    }
}
