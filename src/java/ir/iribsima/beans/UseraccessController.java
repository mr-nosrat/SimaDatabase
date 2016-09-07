package ir.iribsima.beans;

import ir.iribsima.entities.Useraccess;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "useraccessController")
@ViewScoped
public class UseraccessController extends AbstractController<Useraccess> {

    @Inject
    private UsersController userIDController;
    @Inject
    private AccessController accessIDController;

    public UseraccessController() {
        // Inform the Abstract parent controller of the concrete Useraccess Entity
        super(Useraccess.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        userIDController.setSelected(null);
        accessIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUserID(ActionEvent event) {
        if (this.getSelected() != null && userIDController.getSelected() == null) {
            userIDController.setSelected(this.getSelected().getUserID());
        }
    }

    /**
     * Sets the "selected" attribute of the Access controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccessID(ActionEvent event) {
        if (this.getSelected() != null && accessIDController.getSelected() == null) {
            accessIDController.setSelected(this.getSelected().getAccessID());
        }
    }
}
