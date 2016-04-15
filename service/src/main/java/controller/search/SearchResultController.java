package controller.search;

import base.ResultSearchPojo;
import base.SearchPojo;
import base.TourismAttractionDto;
import domain.base.TourismAttraction;
import org.springframework.webflow.execution.RequestContextHolder;
import services.TourismAttractionService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by peyman on 4/15/2016.
 */
@Named
public class SearchResultController implements Serializable {
          @Inject
    TourismAttractionService tourismAttractionService;
    /*this method for get variable from flow scope*/
    public Object getVariableFromFlow(String variableName) {
        return RequestContextHolder.getRequestContext().getFlowScope().get(variableName);
    }//end of method

    /*this method for putresultPojo variable to flow scope*/
    public void putVariableToFlow(String variableName, Object Variable) {
        RequestContextHolder.getRequestContext().getFlowScope().put(variableName, Variable);
    }//end of method

    public void init() {
        ResultSearchPojo resultPojo = (ResultSearchPojo) getVariableFromFlow("resultPojo");
        if(resultPojo==null){
            resultPojo=new ResultSearchPojo();
        }
        List<TourismAttractionDto> tourismAttractionDto= (List<TourismAttractionDto>) getVariableFromFlow("resultList");
        resultPojo.setTourismAttractionDtoList(tourismAttractionDto);
        putVariableToFlow("resultPojo",resultPojo);
    }
     public String search() {
        SearchPojo searchPojo = (SearchPojo) getVariableFromFlow("searchPojo");
        if (searchPojo.getParam() == null || searchPojo.getParam().equals("")) {
            return "";
        } else {
            List<TourismAttraction> tourismAttractionList = tourismAttractionService.search(searchPojo.getParam());
            putVariableToFlow("resultList", tourismAttractionList);
            return "search";
        }

    }
}




















