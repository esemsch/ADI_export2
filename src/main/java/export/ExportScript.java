package export;

import cablelabs.md.xsd.content._3.BoxCoverType;
import cablelabs.md.xsd.title._3.TitleType;
import export.creators.ImageCreator;
import export.creators.TitleCreator;
import export.dao.MoviesDao;
import model.Movy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xmlmodel.ADIAssetInformation;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * This script runs the whole export.
 */
@SuppressWarnings("ALL")
@Component
public class ExportScript {

    @Autowired
    MoviesDao moviesDao;

    @Autowired
    ExportUtils utils;

    @Autowired
    TitleCreator titleCreator;

    @Autowired
    ImageCreator imageCreator;

    @Transactional
    public void run() throws JAXBException, IOException {
        long time = System.currentTimeMillis();

        List<Movy> movies = moviesDao.getMovies();
        List<Movy> shows = moviesDao.getShows();

        createADI(shows, "OneOff");
        createADI(movies,"Movie");

        System.out.println(((System.currentTimeMillis()-time)/1000)+"s");
    }

    public void createADI(List<Movy> list, String prefix) throws JAXBException, IOException {
        int cnt = 0;
        for (Movy movy : list) {
            System.out.println(movy.getTitle()+" ("+movy.getTmsId()+")");

            TitleType title = titleCreator.createTitle(movy, prefix, null, -1);
            List<BoxCoverType> images = imageCreator.createImages(movy, prefix);

            ADIAssetInformation adiAssetInformation = new ADIAssetInformation(null, title, images);

            utils.marshal(adiAssetInformation, prefix, movy.getTmsId());

            if(cnt++==50) {
//                return;
            }
        }

    }

}
