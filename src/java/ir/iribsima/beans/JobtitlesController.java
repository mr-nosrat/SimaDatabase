package ir.iribsima.beans;

import ir.iribsima.entities.Jobtitles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "jobtitlesController")
@ViewScoped
public class JobtitlesController extends AbstractController<Jobtitles> {

    public JobtitlesController() {
        // Inform the Abstract parent controller of the concrete Jobtitles Entity
        super(Jobtitles.class);
    }

    /**
     * Sets the "items" attribute with a collection of Personnelpattern entities
     * that are retrieved from Jobtitles?cap_first and returns the navigation
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

}
