package ir.iribsima.beans;

import ir.iribsima.entities.Personnels;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "personnelsController")
@ViewScoped
public class PersonnelsController extends AbstractController<Personnels> {

    public PersonnelsController() {
        // Inform the Abstract parent controller of the concrete Personnels Entity
        super(Personnels.class);
    }

    /**
     * Sets the "items" attribute with a collection of Programs entities that
     * are retrieved from Personnels?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of Programs entities that
     * are retrieved from Personnels?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Programs page
     */
    public String navigateProgramsList1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Programs_items", this.getSelected().getProgramsList1());
        }
        return "/entities/programs/index";
    }

    /**
     * Sets the "items" attribute with a collection of Personnelafyshes entities
     * that are retrieved from Personnels?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Personnelafyshes page
     */
    public String navigatePersonnelafyshesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Personnelafyshes_items", this.getSelected().getPersonnelafyshesList());
        }
        return "/entities/personnelafyshes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Productpersonnelafyshes
     * entities that are retrieved from Personnels?cap_first and returns the
     * navigation outcome.
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
