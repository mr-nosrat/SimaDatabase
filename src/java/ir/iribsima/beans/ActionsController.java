package ir.iribsima.beans;

import ir.iribsima.entities.Actions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "actionsController")
@ViewScoped
public class ActionsController extends AbstractController<Actions> {

    public ActionsController() {
        // Inform the Abstract parent controller of the concrete Actions Entity
        super(Actions.class);
    }

}
