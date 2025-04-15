package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceValidationByAdminSteps {

    private String justificatif = null;
    private String requestStatus = "En attente";
    private boolean adminReviewing = false;

    @Given("une demande avec un justificatif est en attente")
    public void une_demande_avec_un_justificatif_est_en_attente() {
        justificatif = "certificat_medical.pdf";
        requestStatus = "En attente";
    }

    @When("l’administrateur consulte la demande")
    public void l_administrateur_consulte_la_demande() {
        if (justificatif != null) {
            adminReviewing = true;
        }
    }

    @When("clique sur {string}")
    public void clique_sur(String action) {
        if (adminReviewing && "Valider".equalsIgnoreCase(action)) {
            requestStatus = "Validée";
        } else if (adminReviewing && "Refuser".equalsIgnoreCase(action)) {
            requestStatus = "Refusée";
        }
    }

    @Then("la demande passe au statut {string}")
    public void la_demande_passe_au_statut(String expectedStatus) {
        assertEquals(expectedStatus, requestStatus);
    }
}
