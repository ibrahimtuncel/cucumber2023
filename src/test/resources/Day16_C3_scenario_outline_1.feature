@scenario_outline_1_google_arama
Feature: Google_Arama_Fonksiyonu
  Scenario Outline:
    Given kullanici google sayfasindadir
      And kullanici "<urun>" arar
      Then kullanici sonuclarda "<urun>" oldugunu verify eder
      Then kullanici application u kapatir.

      Examples:Test Data
        | urun   |
        | Iphone |
        | cicek  |
        | tesla  |
        | bmw  |
        | samsung  |
