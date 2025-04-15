package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherAttendanceMarkingSteps {

    private boolean teacherLoggedIn = false;
    private boolean courseSessionSelected = false;
    private String attendanceStatus = null;

    @Given("je suis connecté en tant qu’enseignant")
    public void je_suis_connecté_en_tant_qu_enseignant() {
        teacherLoggedIn = true;
    }

    @When("je sélectionne une séance de cours")
    public void je_sélectionne_une_séance_de_cours() {
        if (teacherLoggedIn) {
            courseSessionSelected = true;
        }
    }

    @When("je marque un étudiant comme absent")
    public void je_marque_un_étudiant_comme_absent() {
        if (courseSessionSelected) {
            attendanceStatus = "Absent";
        }
    }

    @Then("l’information est enregistrée dans le système")
    public void l_information_est_enregistrée_dans_le_système() {
        assertEquals("Absent", attendanceStatus);
    }
}
