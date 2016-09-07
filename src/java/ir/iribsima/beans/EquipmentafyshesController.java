package ir.iribsima.beans;

import ir.iribsima.entities.Equipmentafyshes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "equipmentafyshesController")
@ViewScoped
public class EquipmentafyshesController extends AbstractController<Equipmentafyshes> {

    @Inject
    private ProgramsController programIDController;
    @Inject
    private EquipmentsController equipmentIDController;
    @Inject
    private CalendartypesController calendartypeIDController;

    public EquipmentafyshesController() {
        // Inform the Abstract parent controller of the concrete Equipmentafyshes Entity
        super(Equipmentafyshes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        programIDController.setSelected(null);
        equipmentIDController.setSelected(null);
        calendartypeIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Programs controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProgramID(ActionEvent event) {
        if (this.getSelected() != null && programIDController.getSelected() == null) {
            programIDController.setSelected(this.getSelected().getProgramID());
        }
    }

    /**
     * Sets the "selected" attribute of the Equipments controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEquipmentID(ActionEvent event) {
        if (this.getSelected() != null && equipmentIDController.getSelected() == null) {
            equipmentIDController.setSelected(this.getSelected().getEquipmentID());
        }
    }

    /**
     * Sets the "selected" attribute of the Calendartypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCalendartypeID(ActionEvent event) {
        if (this.getSelected() != null && calendartypeIDController.getSelected() == null) {
            calendartypeIDController.setSelected(this.getSelected().getCalendartypeID());
        }
    }
}
