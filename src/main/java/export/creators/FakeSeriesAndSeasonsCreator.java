package export.creators;

import cablelabs.md.xsd.core._3.ExtType;
import cablelabs.md.xsd.title._3.LocalizableTitleType;
import cablelabs.md.xsd.title._3.TitleType;
import xmlmodel.*;

import static export.ExportUtils.*;

import javax.xml.bind.JAXBException;

public class FakeSeriesAndSeasonsCreator {

//    public void createFakeSeriesAndSeasons(int numberOfSeries, int seasonsPerSeries, String prefix) throws JAXBException {
//        Episode series = new Episode();
//        Episode seasons = new Episode();
//
//        for(int i = 0; i < numberOfSeries;i++) {
//            TitleType serie = new TitleType();
//            LocalizableTitleType t = new LocalizableTitleType();
//            t.setTitleBrief("Series"+i);
//            serie.getLocalizableTitle().add(t);
//            serie.setShowType("Series");
//            ExtType value = new ExtType();
//            value.getAny().add(new YearOfProductionStart(""+(2000+i*seasonsPerSeries)));
//            value.getAny().add(new YearOfProductionEnd(""+(2000+(i+1)*seasonsPerSeries)));
//            serie.setExt(value);
//            String seriesUriId = "Fake-Series-" + i;
//            serie.setUriId(seriesUriId);
//            series.getTitles().add(serie);
//            for(int j = 0; j < seasonsPerSeries; j++) {
//                TitleType season = new TitleType();
//                LocalizableTitleType tsea = new LocalizableTitleType();
//                tsea.setTitleBrief("Season"+j);
//                season.getLocalizableTitle().add(tsea);
//                season.setUriId("Fake-Season-"+j+"-Of-Series-"+i);
//                season.setShowType("Season");
//                ExtType value1 = new ExtType();
//                value1.getAny().add(new Parent(seriesUriId));
//                value1.getAny().add(new SeasonNumber(j+1));
//                value1.getAny().add(new YearOfProductionStart(""+(2000+i*seasonsPerSeries+j)));
//                value1.getAny().add(new YearOfProductionEnd(""+(2000+i*seasonsPerSeries+j+1)));
//                value1.getAny().add(new Parent(seriesUriId));
//                season.setExt(value1);
//                seasons.getTitles().add(season);
//            }
//        }
//
//        marshal(series, prefix, "series");
//        marshal(seasons, prefix, "seasons");
//    }

}
