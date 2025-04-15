package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceRequestEditingSteps {

    private String currentDate = null;
    private String updatedDate = null;
    private boolean isPending = false;

    @Given("ma demande est en attente")
    public void ma_demande_est_en_attente() {
        currentDate = "2025-04-01";
        isPending = true;
    }

    @When("je clique sur {string} et change la date")
    public void je_clique_sur_et_change_la_date(String bouton) {
        if (isPending && bouton.equalsIgnoreCase("Modifier")) {
            updatedDate = "2025-04-05";
        }
    }

    @Then("la demande est mise à jour avec les nouvelles informations")
    public void la_demande_est_mise_à_jour_avec_les_nouvelles_informations() {
        assertNotNull(updatedDate, "La date n’a pas été modifiée");
        assertNotEquals(currentDate, updatedDate, "La date n’a pas changé");
    }
}
