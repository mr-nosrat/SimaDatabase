package ir.iribsima.beans;

import ir.iribsima.entities.Programtypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "programtypesController")
@ViewScoped
public class ProgramtypesController extends AbstractController<Programtypes> {

    public ProgramtypesController() {
        // Inform the Abstract parent controller of the concrete Programtypes Entity
        super(Programtypes.class);
    }

    /**
     * Sets the "items" attribute with a collection of Programs entities that
     * are retrieved from Programtypes?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Programs page
     */
    public String navigateProgramsList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Programs_items", this.getSelected().getProgramsList());
        }
        return "/entities/programs/index";
    }

}
