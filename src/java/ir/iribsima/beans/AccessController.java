package ir.iribsima.beans;

import ir.iribsima.entities.Access;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "accessController")
@ViewScoped
public class AccessController extends AbstractController<Access> {

    public AccessController() {
        // Inform the Abstract parent controller of the concrete Access Entity
        super(Access.class);
    }

    /**
     * Sets the "items" attribute with a collection of Useraccess entities that
     * are retrieved from Access?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Useraccess page
     */
    public String navigateUseraccessList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Useraccess_items", this.getSelected().getUseraccessList());
        }
        return "/entities/useraccess/index";
    }

}
