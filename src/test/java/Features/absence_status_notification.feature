Feature: Notification après validation de la demande

  Scenario: Un étudiant reçoit une notification suite à la validation de sa demande
    Given une de mes demandes vient d’être validée
    Then je reçois une notification par mail ou sur l’interface utilisateur
