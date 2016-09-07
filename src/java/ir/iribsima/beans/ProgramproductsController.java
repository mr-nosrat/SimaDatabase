package ir.iribsima.beans;

import ir.iribsima.entities.Programproducts;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "programproductsController")
@ViewScoped
public class ProgramproductsController extends AbstractController<Programproducts> {

    @Inject
    private UnitsController unitIDController;
    @Inject
    private ProgramsController programIDController;
    @Inject
    private LocationsController locationIDController;
    @Inject
    private CalendartypesController calendartypeIDController;

    public ProgramproductsController() {
        // Inform the Abstract parent controller of the concrete Programproducts Entity
        super(Programproducts.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        unitIDController.setSelected(null);
        programIDController.setSelected(null);
        locationIDController.setSelected(null);
        calendartypeIDController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Productequipmetafyshes
     * entities that are retrieved from Programproducts?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for Productequipmetafyshes page
     */
    public String navigateProductequipmetafyshesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Productequipmetafyshes_items", this.getSelected().getProductequipmetafyshesList());
        }
        return "/entities/productequipmetafyshes/index";
    }

    /**
     * Sets the "selected" attribute of the Units controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnitID(ActionEvent event) {
        if (this.getSelected() != null && unitIDController.getSelected() == null) {
            unitIDController.setSelected(this.getSelected().getUnitID());
        }
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

    /**
     * Sets the "items" attribute with a collection of Productpersonnelafyshes
     * entities that are retrieved from Programproducts?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for Productpersonnelafyshes page
     */
    public String navigateProductpersonnelafyshesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Productpersonnelafyshes_items", this.getSelected().getProductpersonnelafyshesList());
        }
        return "/entities/productpersonnelafyshes/index";
    }

    
}
