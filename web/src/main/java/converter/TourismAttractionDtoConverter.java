package converter;

import base.LocationDto;
import base.TourismAttractionDto;
import services.LocationService;
import services.TourismAttractionService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by peyman on 4/14/2016.
 */
@Named
public class TourismAttractionDtoConverter implements Converter {
    @Inject
    TourismAttractionService locationService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return locationService.getTourismAttractionDtos().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid category."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((TourismAttractionDto) object).getId());
        }
        else {
            return null;
        }
    }
}
