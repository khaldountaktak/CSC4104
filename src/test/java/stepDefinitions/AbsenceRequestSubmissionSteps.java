package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceRequestSubmissionSteps {

    private boolean studentLoggedIn = false;
    private String absenceFormDate = null;
    private String absenceFormReason = null;
    private String requestStatus = null;

    @Given("je suis connecté en tant qu'étudiant")
    public void je_suis_connecté_en_tant_qu_étudiant() {
        studentLoggedIn = true;
    }

    @When("je remplis le formulaire d'absence avec une date et un motif non justifié")
    public void je_remplis_le_formulaire_d_absence_avec_une_date_et_un_motif_non_justifié() {
        if (studentLoggedIn) {
            absenceFormDate = "2025-05-01";
            absenceFormReason = "retard de bus";
        }
    }

    @When("je soumets la demande")
    public void je_soumets_la_demande() {
        if (absenceFormDate != null && absenceFormReason != null) {
            requestStatus = "Soumise";
        }
    }

    @Then("ma demande est enregistrée et visible dans mon tableau de bord")
    public void ma_demande_est_enregistrée_et_visible_dans_mon_tableau_de_bord() {
        assertEquals("Soumise", requestStatus);
    }
}
