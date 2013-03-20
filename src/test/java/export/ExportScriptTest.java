package export;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import export.dao.MoviesDao;
import model.Movy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

public class ExportScriptTest {

    ExportScript es;

    @Mock
    MoviesDao md;

    @Mock
    ExportUtils eu;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        es = new ExportScript();

        es.moviesDao = md;
        es.utils = eu;
    }

    @Test
    public void testSomething() throws JAXBException, IOException {
        when(md.getMovies()).thenReturn(new ArrayList<Movy>());
        when(md.getShows()).thenReturn(new ArrayList<Movy>());

        es.run();

        assertTrue(true);
    }

    @Test(expected = NullPointerException.class)
    public void testFail() throws JAXBException, IOException {
        when(md.getMovies()).thenReturn(null);
        when(md.getShows()).thenReturn(null);

        es.run();
    }
}
