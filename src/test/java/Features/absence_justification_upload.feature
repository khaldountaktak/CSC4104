Feature: Téléversement de justificatif

  Scenario: Ajouter un certificat médical à une absence
    Given je remplis une demande d’absence
    When je téléverse un certificat médical en PDF
    Then le fichier est associé à ma demande
