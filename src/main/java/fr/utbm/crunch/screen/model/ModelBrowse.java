package fr.utbm.crunch.screen.model;

import fr.utbm.crunch.entity.Equipment;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.FileStorageResource;
import io.jmix.ui.component.Image;
import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Model.browse")
@UiDescriptor("model-browse.xml")
@LookupComponent("modelsTable")
public class ModelBrowse extends StandardLookup<Model> {

    @Autowired
    private UiComponents uiComponents;
    @Install(to = "modelsTable.image", subject = "columnGenerator")
    public Component modelsTableLogoColumnGenerator(Model model) {
        if (model.getImage() != null){
            Image image = uiComponents.create(Image.class);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setSource(FileStorageResource.class)
                    .setFileReference(model.getImage());
            image.setWidth("30px");
            image.setHeight("30px");
            return image;
        }
        return null;
    }

}