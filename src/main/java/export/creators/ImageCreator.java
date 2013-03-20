package export.creators;

import cablelabs.md.xsd.content._3.BoxCoverType;
import export.ExportUtils;
import model.Image;
import model.Movy;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageCreator {

    @Value("${source.folder}")
    private String sourceFolder;

    @Value("${destination.folder}")
    private String destinationFolder;

    public List<BoxCoverType> createImages(Movy m, String prefix) throws IOException {
        /*
    <Asset xsi:type="content:BoxCoverType" uriId="indemand.com/Asset/UNVA2001081701006004" providerVersionNum="1"
           internalVersionNum="0" creationDateTime="2002-01-11T00:00:00Z" startDateTime="2002-02-01T00:00:00Z"
           endDateTime="2002-03-31T11:59:59Z">
        <content:SourceUrl>Arli_35_Box_Cover.bmp</content:SourceUrl>
        <content:Language>en</content:Language>
    </Asset>
         */

        List<Image> images = m.getImages();
        List<BoxCoverType> retVal = new ArrayList<BoxCoverType>();

        for (Image image : images) {
            BoxCoverType image1 = createImage(image);
            if(image1!=null) {
                image1.setUriId(ExportUtils.getUriId(prefix, m));
                if(image1.getLanguage()==null) {  // TODO: ??
                    image1.setLanguage(m.getDescriptionLang());
                }
                retVal.add(image1);
            }
        }

        return retVal;
    }

    private BoxCoverType createImage(Image img) throws IOException {
        File sourceImage = img.getUri()!=null ? new File(sourceFolder+File.separator+img.getUri()) : null;
        if(sourceImage==null || !sourceImage.exists()) {
            return null;
        }
        File destFolder = new File(destinationFolder);
        FileUtils.copyFileToDirectory(sourceImage,destFolder);

        BoxCoverType boxCoverType = new BoxCoverType();
        boxCoverType.setLanguage(img.getLang());
        boxCoverType.setSourceUrl(sourceImage.getName());

        return boxCoverType;
    }

}
