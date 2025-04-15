Feature: Modification d’une demande d’absence

  Scenario: Modifier la date d’une demande en attente
    Given ma demande est en attente
    When je clique sur "Modifier" et change la date
    Then la demande est mise à jour avec les nouvelles informations
