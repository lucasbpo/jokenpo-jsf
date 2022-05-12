package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author lucasbpo
 */
@FacesConverter(value = "rankingConverter")
public class RankingConverter implements Converter<Double>{

    @Override
    public Double getAsObject(FacesContext context, UIComponent component, String value) {
        return Double.parseDouble(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Double value) {
        return String.valueOf(value);
    }

    
}
