package controller.search;

import base.SearchPojo;
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
public class SearchController implements Serializable {
    @Inject
    TourismAttractionService tourismAttractionService;

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


    /*this method for get variable from flow scope*/
    public Object getVariableFromFlow(String variableName) {
        return RequestContextHolder.getRequestContext().getFlowScope().get(variableName);
    }//end of method

    /*this method for put variable to flow scope*/
    public void putVariableToFlow(String variableName, Object Variable) {
        RequestContextHolder.getRequestContext().getFlowScope().put(variableName, Variable);
    }//end of method

    public void init() {
        Object searchPojoObj = getVariableFromFlow("searchPojo");
        SearchPojo searchPojo;
        if (searchPojoObj != null) {
            searchPojo = (SearchPojo) searchPojoObj;
        } else {
            searchPojo = new SearchPojo();
        }
        putVariableToFlow("searchPojo", searchPojo);
    }
}
