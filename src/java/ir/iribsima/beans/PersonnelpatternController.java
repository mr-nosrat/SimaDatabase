package ir.iribsima.beans;

import ir.iribsima.entities.Personnelpattern;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personnelpatternController")
@ViewScoped
public class PersonnelpatternController extends AbstractController<Personnelpattern> {

    @Inject
    private UnitsController unitIDController;
    @Inject
    private JobtitlesController jobtitleIDController;

    public PersonnelpatternController() {
        // Inform the Abstract parent controller of the concrete Personnelpattern Entity
        super(Personnelpattern.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        unitIDController.setSelected(null);
        jobtitleIDController.setSelected(null);
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
     * Sets the "selected" attribute of the Jobtitles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareJobtitleID(ActionEvent event) {
        if (this.getSelected() != null && jobtitleIDController.getSelected() == null) {
            jobtitleIDController.setSelected(this.getSelected().getJobtitleID());
        }
    }
}
