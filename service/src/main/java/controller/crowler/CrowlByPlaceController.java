package controller.crowler;

import base.CategoryDto;
import base.LocationDto;
import base.TourismAttractionDto;
import base.TourismAttractionInfoDto;
import com.eyeson.crawler.dto.NearByPlacesByType;
import crowler.CrowlerData;
import org.springframework.webflow.execution.RequestContextHolder;
import se.walkercrou.places.Place;
import services.CategoryService;
import services.LocationService;
import services.TourismAttractionService;
import services.crowler.WebCrowlerService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k.hahsemi on 4/14/2016.
 */
@Named
public class CrowlByPlaceController implements Serializable {

    @Inject
    CategoryService categoryService;
    @Inject
    LocationService locationService;
    @Inject
    TourismAttractionService tourismAttractionService;
    @Inject
    WebCrowlerService webCrowlerService;
    private String selectedPlace;

    public String getSelectedPlace() {
        return selectedPlace;
    }

    public void setSelectedPlace(String selectedPlace) {
        this.selectedPlace = selectedPlace;
    }

    /*this method for create new Instance of InputFormPojo*/
    public void initView() {
        TourismAttractionDto tourismAttractionDto = new TourismAttractionDto();
        tourismAttractionDto.setTourismAttractionInfoDtoList(new ArrayList<TourismAttractionInfoDto>());
        putVariableToFlow("tourismAttractionDto", tourismAttractionDto);
    }//end of method

    public void importData()
    {
        LocationDto locationDto=new LocationDto();
        locationDto.setName(selectedPlace);
        List<CategoryDto> categories=new ArrayList<CategoryDto>();
        CrowlerData foundData = webCrowlerService.findData(locationDto, categories, 10, 2000, false);
        List<TourismAttractionDto> retList=new ArrayList<TourismAttractionDto>();
        if(foundData!=null)
         for(NearByPlacesByType nbt: foundData.getNearByPlaces())
         {
             if(nbt.getPlaces()!=null)
             {
                 for(Place p:nbt.getPlaces())
                 {
                     TourismAttractionDto tar=new TourismAttractionDto();
                     tar.setName( p.getName());
                     String detail=webCrowlerService.getWikiDataByPlaceName(tar.getName());
                     if(detail!=null)
                     tar.setName(tar.getName()+detail);
                     retList.add(tar);
                 }
             }
         }

        tourismAttractionService.saveAtractionList(retList);
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(retList.size() + " مورد به پایگاه داده اضافه شد"));
    }

    // /*this method for get location with title liked $query*/
    public List<String> locationDtoComplete(String query) {
        List<String> rets=new ArrayList<String>();
        List<LocationDto> ldtos = locationService.locationDtoComplete(query);
        for(LocationDto ld:ldtos)
        {
            rets.add(ld.getName());
        }
        return  rets;
    }//end of method

    /*this method for get variable from flow scope*/
    public Object getVariableFromFlow(String variableName) {
        return RequestContextHolder.getRequestContext().getFlowScope().get(variableName);
    }//end of method

    /*this method for put variable to flow scope*/
    public void putVariableToFlow(String variableName, Object Variable) {
        RequestContextHolder.getRequestContext().getFlowScope().put(variableName, Variable);
    }//end of method
}

