package fr.utbm.crunch.screen.equipment;

import fr.utbm.crunch.entity.Brand;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.FileStorageResource;
import io.jmix.ui.component.Image;
import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Equipment.browse")
@UiDescriptor("equipment-browse.xml")
@LookupComponent("equipmentsTable")
public class EquipmentBrowse extends StandardLookup<Equipment> {

    @Autowired
    private UiComponents uiComponents;
    @Install(to = "equipmentsTable.image", subject = "columnGenerator")
    public Component equipmentsTableLogoColumnGenerator(Equipment equipment) {
        if (equipment.getImage() != null){
            Image image = uiComponents.create(Image.class);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setSource(FileStorageResource.class)
                    .setFileReference(equipment.getImage());
            image.setWidth("30px");
            image.setHeight("30px");
            return image;
        }
        return null;
    }

}