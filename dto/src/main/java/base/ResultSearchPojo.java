package base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyman on 4/15/2016.
 */
public class ResultSearchPojo implements Serializable {
    private List<TourismAttractionDto> tourismAttractionDtoList;

    public List<TourismAttractionDto> getTourismAttractionDtoList() {
        return tourismAttractionDtoList;
    }

    public void setTourismAttractionDtoList(List<TourismAttractionDto> tourismAttractionDtoList) {
        this.tourismAttractionDtoList = tourismAttractionDtoList;
    }
}
