package export.creators;

import cablelabs.md.xsd.core._3.ExtType;
import cablelabs.md.xsd.core._3.PersonType;
import cablelabs.md.xsd.core._3.RatingType;
import cablelabs.md.xsd.title._3.LocalizableTitleType;
import cablelabs.md.xsd.title._3.TitleType;
import export.ExportUtils;
import model.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import xmlmodel.EpisodeNumber;
import xmlmodel.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static export.ExportUtils.xmlCal;

@Component
public class TitleCreator {


    public TitleType createTitle(Movy m, String prefix, String parentUriId, int episodeNumber) {

        TitleType title = new TitleType();

        /*
        <Asset xsi:type="title:TitleType" uriId="indemand.com/Title/UNVA2001081701004001" providerVersionNum="1"
           internalVersionNum="0" creationDateTime="2002-01-11T00:00:00Z" startDateTime="2002-02-01T00:00:00Z"
           endDateTime="2002-03-31T11:59:59Z">
         */


        title.setUriId(ExportUtils.getUriId(prefix, m));  // ok
//        title.setProviderVersionNum(BigInteger.ONE);  // TODO: ??
//        title.setInternalVersionNum(BigInteger.ZERO); // TODO: ??
//        title.setCreationDateTime(xmlCal(new DateTime(2013,3,18,13,55))); // TODO: ??
//        title.setStartDateTime(xmlCal(new DateTime(2013,3,18,15,55)));  // TODO: ??
//        title.setEndDateTime(xmlCal(new DateTime(2014,3,18,13,55))); // TODO: ??

        /*
        <core:Ext>
            <parent>indemand.com/Title/UNVA2001081701004002</parent>
            <episodeNumber>1</episodeNumber>
        </core:Ext>
        */
        // TODO: only for series?
        if(parentUriId!=null) {
            ExtType ext = new ExtType();
            ext.getAny().add(new Parent(parentUriId));
            ext.getAny().add(new EpisodeNumber(episodeNumber));
            title.setExt(ext);
        }

        /*
        <title:LocalizableTitle>
            <title:TitleSortName>Titanic, The</title:TitleSortName>
            <title:TitleBrief>The Titanic</title:TitleBrief>
            <title:TitleMedium>The Titanic</title:TitleMedium>
            <title:TitleLong>The Titanic</title:TitleLong>
            <title:SummaryShort>Fictional romantic tale of a rich girl and poor boy who meet on the ill-fated voyage of
                the
                'unsinkable' ship
            </title:SummaryShort>
            <title:SummaryMedium>Fictional romantic tale of rich girl and poor boy who meet on the ill-fated voyage of
                the
                'unsinkable' ship
            </title:SummaryMedium>
            <title:SummaryLong>Fictional romantic tale of a rich girl and poor boy who meet on the ill-fated voyage of
                the
                'unsinkable' ship
            </title:SummaryLong>
            <title:ActorDisplay>Kate Winslet,Leonardo DiCaprio, Billy Zane</title:ActorDisplay>
            <title:Actor fullName="Kate Winslet" firstName="Kate" lastName="Winslet" sortableName="Winslet,Kate"/>
            <title:Actor fullName="Leonardo DiCaprio" firstName="Leonardo" lastName="DiCaprio"
                         sortableName="DiCaprio,Leonardo"/>
            <title:Actor fullName="Billy Zane" firstName="Billy" lastName="Zane" sortableName="Zane,Billy"/>
            <title:WriterDisplay>James Cameron</title:WriterDisplay>
            <title:Director fullName="James Cameron" firstName="James" lastName="Cameron"
                            sortableName="Cameron,James"/>
            <title:StudioDisplay>Paramount</title:StudioDisplay>
            <title:RecordingArtist>Celine Dion</title:RecordingArtist>
            <title:SongTitle>My Heart Will Go On</title:SongTitle>
            <title:EpisodeName>Collision With destiny</title:EpisodeName>
            <title:EpisodeID>The only one</title:EpisodeID>
            <title:Chapter heading="Opening Scene" timeCode="00:00:02:00"/>
            <title:Chapter heading="They Meet" timeCode="00:15:12:00"/>
            <title:Chapter heading="The Collision" timeCode="02:03:06:00"/>
            <title:Chapter heading="She Goes Under" timeCode="02:55:15:00"/>
            <title:Chapter heading="Final Scene" timeCode="03:02:09:00"/>
        </title:LocalizableTitle>
        */

        LocalizableTitleType locTitle = new LocalizableTitleType();
        DisplayNameAndPersonTypeList actors = getDisplayListFromCast(m.getCasts());
        locTitle.setActorDisplay(actors.displayName); // ok
        locTitle.getActor().addAll(actors.personTypeList); // ok
        DisplayNameAndPersonTypeList directors = getDisplayListFromCrew(m.getCrews(), "=", "Director");
        locTitle.setDirectorDisplay(directors.displayName);  // ok - get by role = Director
        locTitle.getDirector().addAll(directors.personTypeList); // ok
//        locTitle.setEpisodeID("??????????");  // TODO: ??
//        locTitle.setEpisodeName("??????????");  // TODO: ??
        locTitle.setLang(m.getDescriptionLang());  //  ok - descriptionLang
        DisplayNameAndPersonTypeList producers = getDisplayListFromCrew(m.getCrews(), "like", "Producer");
        locTitle.setProducerDisplay(producers.displayName); // ok - get by role = Producer / Executive Producer
        locTitle.getProducer().addAll(producers.personTypeList); // ok
        DisplayNameAndPersonTypeList recArtists = getDisplayListFromCrew(m.getCrews(), "=", "Original Music");
        locTitle.setRecordingArtistDisplay(recArtists.displayName); // ok - get by role = Original Music
        locTitle.getRecordingArtist().addAll(recArtists.getNameList());
//        locTitle.setStudioDisplay("??????????");  // TODO: ??
        locTitle.setSummaryLong(m.getLongDescription());  // ok long description
        locTitle.setSummaryMedium(m.getShortDescription()); // ok short description
        locTitle.setSummaryShort(m.getShortDescription());  // ok short descr.
        locTitle.setTitleBrief(m.getTitle());  // title
        locTitle.setTitleLong(m.getTitle());  // title
        locTitle.setTitleMedium(m.getTitle());  // title
        locTitle.setTitleSortName(getSortTitle(m.getTitle()));  // title -> to sort name (algorithm?)
        DisplayNameAndPersonTypeList writers = getDisplayListFromCrew(m.getCrews(), "like", "Writer");
        locTitle.setWriterDisplay(writers.displayName);  // ok - get by role = Writer
        locTitle.getWriter().addAll(writers.personTypeList); // ok
//        ChapterType ct = new ChapterType();  // TODO: ??
//        ct.setHeading("??????????");
//        ct.setTimeCode("??????????");
//        locTitle.getChapter().add(ct);

        title.getLocalizableTitle().add(locTitle);

        /*
        <title:Rating ratingSystem="MPAA">R</title:Rating>
        <title:Advisory>AL</title:Advisory>
        <title:Advisory>N</title:Advisory>
        <title:IsClosedCaptioning>false</title:IsClosedCaptioning>
        <title:DisplayRunTime>03:14</title:DisplayRunTime>
        <title:Year>1997</title:Year>
        <title:CountryOfOrigin>US</title:CountryOfOrigin>
        <title:Genre>Drama</title:Genre>
        <title:Genre>Romance</title:Genre>
        <title:ShowType>Episode</title:ShowType>
        <title:IsSeasonPremiere>false</title:IsSeasonPremiere>
        <title:IsSeasonFinale>false</title:IsSeasonFinale>
        <title:IsEncryptionRequired>true</title:IsEncryptionRequired>
        <title:BoxOffice>1835000000</title:BoxOffice>
        <title:ProgrammerCallLetters>IND</title:ProgrammerCallLetters>
         */
        title.getRating().addAll(createRatings(m.getRatings())); // ok
//        title.getAdvisory().add(null); // TODO: ??
//        title.setIsClosedCaptioning(false); // TODO: ??
        if(m.getRunTime()!=null) {
            title.setDisplayRunTime(""+getRuntimeInMillis(m.getRunTime())); // ok - runtime
        }
        if(m.getReleaseYear()!=null) {
            title.setYear(xmlCal(new DateTime(m.getReleaseYear().intValue(),1,1,0,0))); // ok - releaseYear
        }
//        title.setCountryOfOrigin(null); // TODO: ??
        title.getGenre().addAll(getGenres(m.getGenres())); // ok
        title.setShowType(m.getEntityType()); // ok
//        title.setIsSeasonPremiere(false);  // TODO: ??  series only?
//        title.setIsSeasonFinale(false); // TODO: ?? series only?
//        title.setIsEncryptionRequired(false); // TODO: ??
//        title.setBoxOffice(null); // TODO: ??
//        title.setProgrammerCallLetters(null); // TODO: algorithm?

        return title;
    }

    private long getRuntimeInMillis(String runtime) {
        Matcher matcher = Pattern.compile("PT(\\d{2})H(\\d{2})M").matcher(runtime);
        assert matcher.find() : runtime+" DOES NOT MATCH";

        return (Integer.parseInt(matcher.group(1))*60+Integer.parseInt(matcher.group(2)))*60*1000;
    }

    private List<String> getGenres(List<Genre> genres) {
        List<String> retVal = new ArrayList<String>();
        for (Genre genre : genres) {
            retVal.add(genre.getGenre());
        }
        return retVal;
    }

    private List<RatingType> createRatings(List<Rating> ratings) {
        List<RatingType> retVal = new ArrayList<RatingType>();
        for (Rating rating : ratings) {
            RatingType ratingtype = new RatingType();
            ratingtype.setRatingSystem(rating.getRatingtype().getBody());
            ratingtype.setValue(rating.getValue());
            retVal.add(ratingtype);
        }
        return  retVal;
    }

    private String getSortTitle(String title) {
        if(title.toLowerCase().startsWith("the ")) {
            return title.substring(4) + ", The";
        }
        return title;
    }

    private DisplayNameAndPersonTypeList getDisplayListFromCast(List<Cast> c) {
        StringBuilder sb = new StringBuilder("");
        List<PersonType> ptList = new ArrayList<PersonType>();

        for (Cast cast : c) {
            String name = cast.getPerson().getName();
            sb.append(name +", ");
            ptList.add(fromName(name));
        }

        return fixResult(sb.toString(),ptList);
    }

    private DisplayNameAndPersonTypeList getDisplayListFromCrew(List<Crew> c, String... filter) {
        StringBuilder sb = new StringBuilder("");
        List<PersonType> ptList = new ArrayList<PersonType>();

        for (Crew crew : c) {
            boolean matches = true;
            if(filter!=null && filter.length>0) {
                assert filter.length%2 == 0;
                matches = false;
                for (int i = 0; i < filter.length; i+=2) {
                    String o = filter[i];
                    String s = filter[i+1];
                    assert o.equals("=") || o.equals("like");
                    if((o.equals("=") && crew.getRole().equals(s))
                            || (o.equals("like") && crew.getRole().toLowerCase().contains(s.toLowerCase()))) {
                        matches = true;
                        break;
                    }
                }
            }
            if(matches) {
                String name = crew.getPerson().getName();
                sb.append(name +", ");
                ptList.add(fromName(name));
            }
        }
        return fixResult(sb.toString(),ptList);
    }

    private DisplayNameAndPersonTypeList fixResult(String displName, List<PersonType> ptList) {
        return ptList.isEmpty()? DisplayNameAndPersonTypeList.EMPTY : new DisplayNameAndPersonTypeList(displName.substring(0, displName.length() - 2),ptList);
    }

    private PersonType fromName(String name) {
        StringTokenizer st = new StringTokenizer(name, " ");
        String firstName = "";
        String lastName = "";
        boolean first = true;
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if(first) {
                first = false;
            } else {
                firstName += lastName+" ";
            }
            lastName = token;
        }
        firstName = firstName.length()>0?firstName.substring(0,firstName.length()-1):"";
        PersonType personType = new PersonType();
        personType.setFirstName(firstName);
        personType.setLastName(lastName);
        personType.setFullName(name);
        personType.setSortableName(lastName+", "+firstName);

        return personType;
    }
}
