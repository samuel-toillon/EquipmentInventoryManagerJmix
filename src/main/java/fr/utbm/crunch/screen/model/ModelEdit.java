package fr.utbm.crunch.screen.model;

import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Model;

@UiController("Model.edit")
@UiDescriptor("model-edit.xml")
@EditedEntityContainer("modelDc")
public class ModelEdit extends StandardEditor<Model> {
}