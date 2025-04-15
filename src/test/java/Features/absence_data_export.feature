Feature: Export des absences par l’administrateur

  Scenario: Génération d’un fichier Excel d’absences
    Given je suis connecté en tant qu’administrateur
    When je clique sur "Exporter les absences"
    Then un fichier Excel est généré avec toutes les absences filtrées
