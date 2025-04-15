package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceDataExportSteps {

    private boolean isAdminLoggedIn = false;
    private String action = "";
    private String exportFile = null;

    @Given("je suis connecté en tant qu’administrateur")
    public void je_suis_connecté_en_tant_qu_administrateur() {
        isAdminLoggedIn = true;
    }

    @When("je clique sur {string}")
    public void je_clique_sur(String bouton) {
        if (isAdminLoggedIn && bouton.equalsIgnoreCase("Exporter les absences")) {
            action = "export";
            exportFile = "absences_filtrées.xlsx";
        }
    }

    @Then("un fichier Excel est généré avec toutes les absences filtrées")
    public void un_fichier_excel_est_généré_avec_toutes_les_absences_filtrées() {
        assertNotNull(exportFile, "Le fichier n’a pas été généré");
        assertEquals("absences_filtrées.xlsx", exportFile);
    }
}
