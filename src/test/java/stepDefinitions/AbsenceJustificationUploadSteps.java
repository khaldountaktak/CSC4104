package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceJustificationUploadSteps {

    private boolean absenceFormFilled = false;
    private String uploadedFile = null;

    @Given("je remplis une demande d’absence")
    public void je_remplis_une_demande_d_absence() {
        absenceFormFilled = true;
    }

    @When("je téléverse un certificat médical en PDF")
    public void je_téléverse_un_certificat_médical_en_pdf() {
        if (absenceFormFilled) {
            uploadedFile = "certificat_medical.pdf";
        }
    }

    @Then("le fichier est associé à ma demande")
    public void le_fichier_est_associé_à_ma_demande() {
        assertNotNull(uploadedFile, "Aucun fichier téléversé");
        assertTrue(uploadedFile.endsWith(".pdf"), "Le fichier n'est pas un PDF");
    }
}
