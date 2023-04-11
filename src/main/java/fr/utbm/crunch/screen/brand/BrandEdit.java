package fr.utbm.crunch.screen.brand;

import io.jmix.ui.screen.*;
import fr.utbm.crunch.entity.Brand;

@UiController("Brand.edit")
@UiDescriptor("brand-edit.xml")
@EditedEntityContainer("brandDc")
public class BrandEdit extends StandardEditor<Brand> {
}