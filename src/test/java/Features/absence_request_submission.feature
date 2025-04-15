Feature: Soumission de demande d’absence

  Scenario: Un étudiant soumet une demande d’absence non justifiée
    Given je suis connecté en tant qu'étudiant
    When je remplis le formulaire d'absence avec une date et un motif non justifié
    And je soumets la demande
    Then ma demande est enregistrée et visible dans mon tableau de bord
