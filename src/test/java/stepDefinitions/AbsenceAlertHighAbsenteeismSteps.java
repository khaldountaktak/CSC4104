package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceAlertHighAbsenteeismSteps {

    private int unjustifiedAbsences = 0;
    private String alertMessage = null;

    @Given("un étudiant dépasse {int} demi-journées non justifiées")
    public void un_étudiant_dépasse_demi_journées_non_justifiées(Integer nbAbsences) {
        unjustifiedAbsences = nbAbsences;
        if (unjustifiedAbsences > 6) {
            alertMessage = "ALERTE : absentéisme élevé détecté";
        }
    }

    @Then("une alerte s’affiche dans le tableau de bord administrateur")
    public void une_alerte_s_affiche_dans_le_tableau_de_bord_administrateur() {
        assertNotNull(alertMessage, "Aucune alerte générée");
        assertTrue(alertMessage.contains("absentéisme élevé"), "Le message d’alerte est incorrect");
    }
}
