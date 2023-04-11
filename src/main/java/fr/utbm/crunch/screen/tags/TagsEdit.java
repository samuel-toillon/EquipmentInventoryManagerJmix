package fr.utbm.crunch.screen.tags;

import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Tags;

@UiController("Tags.edit")
@UiDescriptor("tags-edit.xml")
@EditedEntityContainer("tagsDc")
public class TagsEdit extends StandardEditor<Tags> {
}