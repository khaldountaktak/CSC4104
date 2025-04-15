Feature: Marquage de l’absence par l’enseignant

  Scenario: Enregistrement d'une absence pendant une séance
    Given je suis connecté en tant qu’enseignant
    When je sélectionne une séance de cours
    And je marque un étudiant comme absent
    Then l’information est enregistrée dans le système
