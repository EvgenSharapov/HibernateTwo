package entity.film;


import lombok.Getter;

import java.util.Optional;

import static java.util.Objects.isNull;

@Getter
public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String feature;

    SpecialFeatures(String feature) {
        this.feature = feature;
    }

    public static SpecialFeatures getFeaturesByValue(String feature){
        if(isNull(feature) || feature.isEmpty()){
            return null;}
        SpecialFeatures[]values=SpecialFeatures.values();
        for(SpecialFeatures value : values){
            if(value.feature.equals(feature)){
                return value;
            }
        }
        return null;
    }
}
