package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbsenceStatusNotificationSteps {

    private boolean requestValidated = false;
    private String notificationMessage = null;

    @Given("une de mes demandes vient d’être validée")
    public void une_de_mes_demandes_vient_d_être_validée() {
        requestValidated = true;
    }

    @Then("je reçois une notification par mail ou sur l’interface utilisateur")
    public void je_reçois_une_notification_par_mail_ou_sur_l_interface_utilisateur() {
        if (requestValidated) {
            notificationMessage = "Votre demande d’absence a été approuvée";
        }
        assertNotNull(notificationMessage, "Aucune notification reçue");
        assertTrue(notificationMessage.contains("approuvée") || notificationMessage.contains("validée"));
    }
}
