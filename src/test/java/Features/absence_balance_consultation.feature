Feature: Consultation du solde d'absences

  Scenario: Affichage du solde
    Given je suis connecté en tant qu’étudiant
    When j’accède à ma page d’accueil
    Then mon solde actuel de demi-journées restantes est affiché
