package ir.iribsima.beans;

import ir.iribsima.entities.Productequipmetafyshes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productequipmetafyshesController")
@ViewScoped
public class ProductequipmetafyshesController extends AbstractController<Productequipmetafyshes> {

    @Inject
    private ProgramproductsController programproductIDController;
    @Inject
    private EquipmentsController equipmentIDController;

    public ProductequipmetafyshesController() {
        // Inform the Abstract parent controller of the concrete Productequipmetafyshes Entity
        super(Productequipmetafyshes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        programproductIDController.setSelected(null);
        equipmentIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Programproducts controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProgramproductID(ActionEvent event) {
        if (this.getSelected() != null && programproductIDController.getSelected() == null) {
            programproductIDController.setSelected(this.getSelected().getProgramproductID());
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
}
