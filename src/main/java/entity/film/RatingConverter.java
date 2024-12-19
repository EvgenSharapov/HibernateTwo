package entity.film;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating,String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getRating();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        Rating[] values = Rating.values();
        for(Rating rating:values){
            if(s.equals(rating.getRating())){return rating;}
        }
        return null;
    }
}
