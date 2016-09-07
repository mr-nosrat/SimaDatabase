package ir.iribsima.beans;

import ir.iribsima.entities.Locations;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "locationsController")
@ViewScoped
public class LocationsController extends AbstractController<Locations> {

    public LocationsController() {
        // Inform the Abstract parent controller of the concrete Locations Entity
        super(Locations.class);
    }

    /**
     * Sets the "items" attribute with a collection of Materials entities that
     * are retrieved from Locations?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Materials page
     */
    public String navigateMaterialsList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Materials_items", this.getSelected().getMaterialsList());
        }
        return "/entities/materials/index";
    }

    /**
     * Sets the "items" attribute with a collection of Personnelafyshes entities
     * that are retrieved from Locations?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Programproducts entities
     * that are retrieved from Locations?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Programproducts page
     */
    public String navigateProgramproductsList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Programproducts_items", this.getSelected().getProgramproductsList());
        }
        return "/entities/programproducts/index";
    }

}
