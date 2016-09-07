package ir.iribsima.beans;

import ir.iribsima.entities.Equipments;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "equipmentsController")
@ViewScoped
public class EquipmentsController extends AbstractController<Equipments> {

    public EquipmentsController() {
        // Inform the Abstract parent controller of the concrete Equipments Entity
        super(Equipments.class);
    }

    /**
     * Sets the "items" attribute with a collection of Equipmentafyshes entities
     * that are retrieved from Equipments?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Productequipmetafyshes
     * entities that are retrieved from Equipments?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Productequipmetafyshes page
     */
    public String navigateProductequipmetafyshesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Productequipmetafyshes_items", this.getSelected().getProductequipmetafyshesList());
        }
        return "/entities/productequipmetafyshes/index";
    }

}
