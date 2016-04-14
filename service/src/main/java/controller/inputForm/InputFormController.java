package controller.inputForm;

import base.CategoryDto;
import base.LocationDto;
import base.TourismAttractionDto;
import base.TourismAttractionInfoDto;
import org.springframework.webflow.execution.RequestContextHolder;
import services.CategoryService;
import services.LocationService;
import services.TourismAttractionService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.spi.LocaleServiceProvider;

/**
 * Created by k.hahsemi on 4/14/2016.
 */
@Named
public class InputFormController implements Serializable {

    @Inject
    CategoryService categoryService;
    @Inject
    LocationService locationService;
    @Inject
    TourismAttractionService tourismAttractionService;


    /*this method for create new Instance of InputFormPojo*/
    public void initView() {
        TourismAttractionDto tourismAttractionDto = new TourismAttractionDto();
        tourismAttractionDto.setTourismAttractionInfoDtoList(new ArrayList<TourismAttractionInfoDto>());
        putVariableToFlow("tourismAttractionDto", tourismAttractionDto);
    }//end of method

    /*this method for get category with title liked $query*/
    public List<CategoryDto> categoryComplete(String query) {
        return categoryService.categoryDtoComplete(query);
    }//end of method
    // /*this method for get location with title liked $query*/
    public List<LocationDto> locationDtoComplete(String query) {
        return locationService.locationDtoComplete(query);
    }//end of method
  // /*this method for get location with title liked $query*/
    public List<TourismAttractionDto> tourismAttractionDtoComplete(String query) {
        return tourismAttractionService.tourismAttractionDtoComplete(query);
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

