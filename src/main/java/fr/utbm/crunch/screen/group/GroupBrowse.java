package fr.utbm.crunch.screen.group;

import io.jmix.core.LoadContext;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.FileStorageResource;
import io.jmix.ui.component.Image;
import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Group_.browse")
@UiDescriptor("group-browse.xml")
@LookupComponent("groupsTable")
public class GroupBrowse extends StandardLookup<Group> {

    @Autowired
    protected UiComponents uiComponents;

    private LoadContext.Query query;

    @Install(to = "groupsTable.icon", subject = "columnGenerator")
    public Component groupsTableLogoColumnGenerator(Group group) { return createImage(group); }

    @Install(to = "groupTreeTable.icon", subject = "columnGenerator")
    public Component groupsTreeTableLogoColumnGenerator(Group group) { return createImage(group); }

    private Component createImage(Group group) {
        if (group.getIcon() != null){
            Image image = uiComponents.create(Image.class);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setSource(FileStorageResource.class)
                    .setFileReference(group.getIcon());
            image.setWidth("30px");
            image.setHeight("30px");
            return image;
        }
        return null;
    }

}