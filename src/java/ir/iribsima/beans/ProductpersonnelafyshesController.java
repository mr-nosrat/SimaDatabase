package ir.iribsima.beans;

import ir.iribsima.entities.Productpersonnelafyshes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productpersonnelafyshesController")
@ViewScoped
public class ProductpersonnelafyshesController extends AbstractController<Productpersonnelafyshes> {

    @Inject
    private ProgramproductsController programproductIDController;
    @Inject
    private PersonnelsController personnelIDController;

    public ProductpersonnelafyshesController() {
        // Inform the Abstract parent controller of the concrete Productpersonnelafyshes Entity
        super(Productpersonnelafyshes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        programproductIDController.setSelected(null);
        personnelIDController.setSelected(null);
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
     * Sets the "selected" attribute of the Personnels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePersonnelID(ActionEvent event) {
        if (this.getSelected() != null && personnelIDController.getSelected() == null) {
            personnelIDController.setSelected(this.getSelected().getPersonnelID());
        }
    }
}
