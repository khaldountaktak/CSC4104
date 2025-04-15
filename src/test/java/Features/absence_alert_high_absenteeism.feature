Feature: Alerte en cas d’absentéisme excessif

  Scenario: Notification automatique à l’administration
    Given un étudiant dépasse 7 demi-journées non justifiées
    Then une alerte s’affiche dans le tableau de bord administrateur
