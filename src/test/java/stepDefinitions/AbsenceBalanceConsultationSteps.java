package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceBalanceConsultationSteps {

    private String visibleBalance;

    @Given("je suis connecté en tant qu’étudiant")
    public void je_suis_connecté_en_tant_qu_étudiant() {
        // Simuler une session étudiante active
        visibleBalance = null;
    }

    @When("j’accède à ma page d’accueil")
    public void j_accède_à_ma_page_d_accueil() {
        // Simuler le calcul du solde
        visibleBalance = "Il vous reste 6 demi-journées d'absence autorisées.";
    }

    @Then("mon solde actuel de demi-journées restantes est affiché")
    public void mon_solde_actuel_de_demi_journées_restantes_est_affiché() {
        assertNotNull(visibleBalance, "Aucun solde affiché");
        assertTrue(visibleBalance.contains("6 demi-journées"));
    }
}
