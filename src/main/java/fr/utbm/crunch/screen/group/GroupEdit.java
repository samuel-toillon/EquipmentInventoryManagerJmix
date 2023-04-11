package fr.utbm.crunch.screen.group;

import io.jmix.core.DataManager;
import io.jmix.core.Metadata;
import io.jmix.ui.component.SingleSelectList;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Group;
import jdk.jfr.Event;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

@UiController("Group_.edit")
@UiDescriptor("group-edit.xml")
@EditedEntityContainer("groupDc")
public class GroupEdit extends StandardEditor<Group> {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(GroupEdit.class);

    @Autowired
    private SingleSelectList<Group> groupList;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private InstanceLoader<Group> groupDl;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        groupDl.load();
        List<Group> groups = new ArrayList<>();
        Group currentGroup = getEditedEntity();
        log.info("" + currentGroup);
        dataManager.load(Group.class)
                .query("select g from Group_ g where g.id <> :currentGroup")
                .parameter("currentGroup", currentGroup.getId())
                .list()
                .forEach(groups::add);
        groupList.setOptionsList(groups);
    }



/*
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GroupEdit.class);
    @Autowired
    protected InstanceContainer<Group> groupDc;

    @Autowired
    protected Metadata metadata;

    @Subscribe(id = "groupDc", target = Target.DATA_CONTAINER)
    public void onGroupDcPicker(InstanceContainer<Group> event) {
        log.info("onGroupPickerEvent");
        Group group = metadata.create(Group.class);
        if (group.getId() != getEditedEntity().getId())
            groupDc.setItem(group);
    }
    */
}