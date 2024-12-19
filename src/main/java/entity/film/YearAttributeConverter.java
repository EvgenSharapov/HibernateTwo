package entity.film;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

import static java.util.Objects.isNull;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year,Short> {
    @Override
    public Short convertToDatabaseColumn(Year year) {
        if(year!=null){
            return (short)year.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Short s) {
        if(s!=null){
            return Year.of(s);}
        return null;
    }
}
