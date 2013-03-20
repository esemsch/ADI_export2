package export.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class ExportDaoTest {

    @Autowired
    MoviesDao moviesDao;

    @Test
    public void testGetMovies() {
        assertFalse(moviesDao.getMovies().isEmpty());
    }

}
