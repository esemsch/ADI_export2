package export.dao;

import model.Movy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MoviesDao {

    @PersistenceContext
    EntityManager em;

    public List<Movy> getMovies() {
        List<Movy> movies = em.createQuery(
                "select distinct m " +
                        "from model.Movy as m join m.ratings as r " +
                        "where size(m.genres) > 0 " +
                        "and m.releaseYear >= 1820 " +
                        "and m.entityType = 'Movie' " +
                        "AND m.descriptionLang = 'en' " +
                        "and (r.ratingtype.body like '%America%' or r.ratingtype.body like '%British%')"
        ).getResultList();

        System.out.println("Movies: "+movies.size());

        return movies;

    }

    public List<Movy> getShows() {
        List<Movy> shows = em.createQuery(
                "select distinct m " +
                        "from model.Movy as m " +
                        "where m.entityType = 'Show' " +
                        "and size(m.genres) > 0 "
        ).getResultList();

        System.out.println("Shows: "+shows.size());

        return shows;
    }

}
