package ir.iribsima.beans;

import ir.iribsima.entities.Personnelafyshes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personnelafyshesController")
@ViewScoped
public class PersonnelafyshesController extends AbstractController<Personnelafyshes> {

    @Inject
    private LocationsController locationIDController;
    @Inject
    private CalendartypesController calendartypeIDController;
    @Inject
    private ProgramsController programIDController;
    @Inject
    private PersonnelsController personnelIDController;

    public PersonnelafyshesController() {
        // Inform the Abstract parent controller of the concrete Personnelafyshes Entity
        super(Personnelafyshes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        locationIDController.setSelected(null);
        calendartypeIDController.setSelected(null);
        programIDController.setSelected(null);
        personnelIDController.setSelected(null);
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
