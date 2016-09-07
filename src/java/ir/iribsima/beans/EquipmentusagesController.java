package ir.iribsima.beans;

import ir.iribsima.entities.Equipmentusages;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "equipmentusagesController")
@ViewScoped
public class EquipmentusagesController extends AbstractController<Equipmentusages> {

    @Inject
    private UnitsController unitlIDController;

    public EquipmentusagesController() {
        // Inform the Abstract parent controller of the concrete Equipmentusages Entity
        super(Equipmentusages.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        unitlIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Units controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnitlID(ActionEvent event) {
        if (this.getSelected() != null && unitlIDController.getSelected() == null) {
            unitlIDController.setSelected(this.getSelected().getUnitlID());
        }
    }
}
