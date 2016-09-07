package ir.iribsima.beans;

import ir.iribsima.entities.Materials;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "materialsController")
@ViewScoped
public class MaterialsController extends AbstractController<Materials> {

    @Inject
    private LocationsController locationIDController;

    public MaterialsController() {
        // Inform the Abstract parent controller of the concrete Materials Entity
        super(Materials.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        locationIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Locations controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLocationID(ActionEvent event) {
        if (this.getSelected() != null && locationIDController.getSelected() == null) {
            locationIDController.setSelected(this.getSelected().getLocationID());
        }
    }
}
