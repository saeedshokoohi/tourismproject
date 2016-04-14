package services;

import base.LocationDto;
import base.TourismAttractionDto;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peyman on 4/14/2016.
 */
@Named
public class TourismAttractionService implements Serializable {
    List<TourismAttractionDto> tourismAttractionDtos = new ArrayList<TourismAttractionDto>();

    public List<TourismAttractionDto> getTourismAttractionDtos() {
        return tourismAttractionDtos;
    }

    public void setTourismAttractionDtos(List<TourismAttractionDto> tourismAttractionDtos) {
        this.tourismAttractionDtos = tourismAttractionDtos;
    }

    @PostConstruct
    public void generateTourismAttractionDtoList() {
        List<TourismAttractionDto> tourismAttractionDtoList = new ArrayList<TourismAttractionDto>();
        TourismAttractionDto tourismAttractionDto = new TourismAttractionDto("کاخ گلستان");
        tourismAttractionDtoList.add(tourismAttractionDto);
        tourismAttractionDto = new TourismAttractionDto("آبشار بیشه");
        tourismAttractionDtoList.add(tourismAttractionDto);
        tourismAttractionDto = new TourismAttractionDto("موزه گیاهشناسی");
        tourismAttractionDtoList.add(tourismAttractionDto);
        setTourismAttractionDtos(tourismAttractionDtoList);
    }

    public List<TourismAttractionDto> tourismAttractionDtoComplete(String query) {
        List<TourismAttractionDto> returnTourismAttractionDtoList = new ArrayList<TourismAttractionDto>();
        for (TourismAttractionDto tourismAttractionDto :getTourismAttractionDtos()) {
            if (tourismAttractionDto.getName().contains(query)) {
                returnTourismAttractionDtoList.add(tourismAttractionDto);
            }
        }
        return returnTourismAttractionDtoList;
    }

}
