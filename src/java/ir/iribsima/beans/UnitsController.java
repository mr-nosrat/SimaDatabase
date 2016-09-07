package ir.iribsima.beans;

import ir.iribsima.entities.Units;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "unitsController")
@ViewScoped
public class UnitsController extends AbstractController<Units> {

    public UnitsController() {
        // Inform the Abstract parent controller of the concrete Units Entity
        super(Units.class);
    }

    /**
     * Sets the "items" attribute with a collection of Programs entities that
     * are retrieved from Units?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Equipmentusages entities
     * that are retrieved from Units?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Equipmentusages page
     */
    public String navigateEquipmentusagesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipmentusages_items", this.getSelected().getEquipmentusagesList());
        }
        return "/entities/equipmentusages/index";
    }

    /**
     * Sets the "items" attribute with a collection of Personnelpattern entities
     * that are retrieved from Units?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Personnelpattern page
     */
    public String navigatePersonnelpatternList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Personnelpattern_items", this.getSelected().getPersonnelpatternList());
        }
        return "/entities/personnelpattern/index";
    }

    /**
     * Sets the "items" attribute with a collection of Programproducts entities
     * that are retrieved from Units?cap_first and returns the navigation
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
