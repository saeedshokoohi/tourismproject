package services;

import base.CategoryDto;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by peyman on 4/14/2016.
 */
@Named
public class CategoryService implements Serializable {
    List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
    public List<CategoryDto> getCategoryDtoList() {
        return categoryDtoList;
    }
    public void setCategoryDtoList(List<CategoryDto> categoryDtoList) {
        this.categoryDtoList = categoryDtoList;
    }

    @PostConstruct
    public void generateGroupList() {
        List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
        CategoryDto categoryDto = new CategoryDto(UUID.randomUUID(), "موزه");
        categoryDtoList.add(categoryDto);
        categoryDto = new CategoryDto(UUID.randomUUID(), "بنای ناریخی");
        categoryDtoList.add(categoryDto);
        categoryDto = new CategoryDto(UUID.randomUUID(), "غدای محلی");
        categoryDtoList.add(categoryDto);
        categoryDto = new CategoryDto(UUID.randomUUID(), "شهر بازی");
        categoryDtoList.add(categoryDto);
        categoryDto = new CategoryDto(UUID.randomUUID(), "جاذبه طبیعی");
        categoryDtoList.add(categoryDto);
        setCategoryDtoList(categoryDtoList);
    }

    public List<CategoryDto> categoryDtoComplete(String query) {
        List<CategoryDto> returnGroupings = new ArrayList<CategoryDto>();
        for (CategoryDto categoryDto : getCategoryDtoList()) {
            if (categoryDto.getTitle().contains(query)) {
                returnGroupings.add(categoryDto);
            }
        }
        return returnGroupings;
    }

}
