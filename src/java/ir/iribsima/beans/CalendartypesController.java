package ir.iribsima.beans;

import ir.iribsima.entities.Calendartypes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "calendartypesController")
@ViewScoped
public class CalendartypesController extends AbstractController<Calendartypes> {

    public CalendartypesController() {
        // Inform the Abstract parent controller of the concrete Calendartypes Entity
        super(Calendartypes.class);
    }

    /**
     * Sets the "items" attribute with a collection of Equipmentafyshes entities
     * that are retrieved from Calendartypes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Equipmentafyshes page
     */
    public String navigateEquipmentafyshesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipmentafyshes_items", this.getSelected().getEquipmentafyshesList());
        }
        return "/entities/equipmentafyshes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Personnelafyshes entities
     * that are retrieved from Calendartypes?cap_first and returns the
     * navigation outcome.
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
     * that are retrieved from Calendartypes?cap_first and returns the
     * navigation outcome.
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
