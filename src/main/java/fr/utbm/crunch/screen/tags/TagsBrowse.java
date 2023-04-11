package fr.utbm.crunch.screen.tags;

import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Tags;

@UiController("Tags.browse")
@UiDescriptor("tags-browse.xml")
@LookupComponent("tagsesTable")
public class TagsBrowse extends StandardLookup<Tags> {
}