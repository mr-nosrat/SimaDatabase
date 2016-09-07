package ir.iribsima.beans;

import ir.iribsima.entities.Programs;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "programsController")
@ViewScoped
public class ProgramsController extends AbstractController<Programs> {

    @Inject
    private UnitsController unitIDController;
    @Inject
    private SubjectsController subjectIDController;
    @Inject
    private ProgramtypesController programtypeIDController;
    @Inject
    private PersonnelsController producerIDController;
    @Inject
    private PersonnelsController directorIDController;
    @Inject
    private ProgramgroupsController productgroupIDController;

    public ProgramsController() {
        // Inform the Abstract parent controller of the concrete Programs Entity
        super(Programs.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        unitIDController.setSelected(null);
        subjectIDController.setSelected(null);
        programtypeIDController.setSelected(null);
        producerIDController.setSelected(null);
        directorIDController.setSelected(null);
        productgroupIDController.setSelected(null);
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
     * Sets the "selected" attribute of the Subjects controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSubjectID(ActionEvent event) {
        if (this.getSelected() != null && subjectIDController.getSelected() == null) {
            subjectIDController.setSelected(this.getSelected().getSubjectID());
        }
    }

    /**
     * Sets the "selected" attribute of the Programtypes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProgramtypeID(ActionEvent event) {
        if (this.getSelected() != null && programtypeIDController.getSelected() == null) {
            programtypeIDController.setSelected(this.getSelected().getProgramtypeID());
        }
    }

    /**
     * Sets the "selected" attribute of the Personnels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProducerID(ActionEvent event) {
        if (this.getSelected() != null && producerIDController.getSelected() == null) {
            producerIDController.setSelected(this.getSelected().getProducerID());
        }
    }

    /**
     * Sets the "selected" attribute of the Personnels controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDirectorID(ActionEvent event) {
        if (this.getSelected() != null && directorIDController.getSelected() == null) {
            directorIDController.setSelected(this.getSelected().getDirectorID());
        }
    }

    /**
     * Sets the "selected" attribute of the Programgroups controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProductgroupID(ActionEvent event) {
        if (this.getSelected() != null && productgroupIDController.getSelected() == null) {
            productgroupIDController.setSelected(this.getSelected().getProductgroupID());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipmentafyshes entities
     * that are retrieved from Programs?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Personnelafyshes entities
     * that are retrieved from Programs?cap_first and returns the navigation
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
     * that are retrieved from Programs?cap_first and returns the navigation
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
