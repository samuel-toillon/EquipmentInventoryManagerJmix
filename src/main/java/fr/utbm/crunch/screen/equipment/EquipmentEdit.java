package fr.utbm.crunch.screen.equipment;

import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Equipment;

@UiController("Equipment.edit")
@UiDescriptor("equipment-edit.xml")
@EditedEntityContainer("equipmentDc")
public class EquipmentEdit extends StandardEditor<Equipment> {
}