package repository;

import dao.*;
import entity.film.*;
import entity.other.FilmText;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmActions implements FilmActionsInterface{
SessionFactory sessionFactory = RepositoryConnections.getInstance().getSessionFactory();
LanguageDAO languageDAO = RepositoryConnections.getInstance().getLanguageDAO();
CategoryDAO categoryDAO = RepositoryConnections.getInstance().getCategoryDAO();
ActorDAO actorDAO = RepositoryConnections.getInstance().getActorDAO();
FilmDAO filmDAO = RepositoryConnections.getInstance().getFilmDAO();
FilmTextDAO filmTextDAO = RepositoryConnections.getInstance().getFilmTextDAO();
    @Override
    public void newFilmAddInStore() {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Language language = languageDAO.getByIdByte((byte) 1);
            List<Category> category = categoryDAO.getItems(0,5);
            List<Actor> actors = actorDAO.getItems(5, 18);

            Film film = new Film();
            film.setActors(new HashSet<>(actors));
            film.setCategories(new HashSet<>(category));
            film.setRating(Rating.R);
            film.setLanguageId(language);
            film.setReleaseYear(Year.now());
            film.setRentalDuration((byte) 4);
            film.setTitle("Words111");
            film.setSpecialFeatures(Set.of(SpecialFeatures.TRAILERS,SpecialFeatures.BEHIND_THE_SCENES));
            film.setLength((short) 120);
            film.setReplacementCost(BigDecimal.valueOf(11.11));
            film.setRentalRate(BigDecimal.valueOf(2.99));
            film.setDescription("funny we111");
            film.setOriginalLanguageId(language);
            filmDAO.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setDescription("funny we111");
            filmText.setTitle("Words111");
            filmText.setId(film.getId());
            filmTextDAO.save(filmText);



            session.getTransaction().commit();}

    }
}
