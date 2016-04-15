package services;

import base.LocationDto;
import base.TourismAttractionDto;
import domain.base.TourismAttraction;
import repository.TourismAttractionRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by peyman on 4/14/2016.
 */
@Named
public class TourismAttractionService implements Serializable {
    List<TourismAttractionDto> tourismAttractionDtos = new ArrayList<TourismAttractionDto>();

    @Inject
    TourismAttractionRepository tourismAttractionRepository;
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

    public void saveAtractionList(List<TourismAttractionDto> retList) {
        if(retList!=null)
        for(TourismAttractionDto tar:retList)
        {
            TourismAttraction tatr=new TourismAttraction();
            tatr.setId(UUID.randomUUID());
            tatr.setName(tar.getName());
            tourismAttractionRepository.save(tatr);

        }
    }
    public List<TourismAttraction> search(String param) {
        return tourismAttractionRepository.search(param);
    }
}
