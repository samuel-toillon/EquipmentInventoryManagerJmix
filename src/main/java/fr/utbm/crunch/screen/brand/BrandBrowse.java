package fr.utbm.crunch.screen.brand;

import fr.utbm.crunch.entity.Group;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.FileStorageResource;
import io.jmix.ui.component.Image;
import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Brand.browse")
@UiDescriptor("brand-browse.xml")
@LookupComponent("brandsTable")
public class BrandBrowse extends StandardLookup<Brand> {

    @Autowired
    private UiComponents uiComponents;
    @Install(to = "brandsTable.image", subject = "columnGenerator")
    public Component brandsTableLogoColumnGenerator(Brand brand) {
        if (brand.getImage() != null){
            Image image = uiComponents.create(Image.class);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setSource(FileStorageResource.class)
                    .setFileReference(brand.getImage());
            image.setWidth("30px");
            image.setHeight("30px");
            return image;
        }
        return null;
    }

}