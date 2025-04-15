Feature: Validation manuelle d’une demande avec justificatif

  Scenario: L’administrateur valide une demande justifiée
    Given une demande avec un justificatif est en attente
    When l’administrateur consulte la demande
    And clique sur "Valider"
    Then la demande passe au statut "Validée"
