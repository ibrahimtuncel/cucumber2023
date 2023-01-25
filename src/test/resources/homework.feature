#ØWhen kullanıcı https://editor.datatables.net/ adresine gider
#ØAnd kullanıcı new button’a Click eder
#ØWhen kullanıcı tüm fields girer
#ØWhen kullanıcı create buttona click eder
#ØAnd kullanıcı first name arar
#ØThen name fields’in first name içerdiğini verify eder
@data_Table_Homework
Feature: scenraio_outline
  @scenario_outline_data_tables
  Scenario Outline:TC01_Testing_data_tables_page
    Given When kullanıcı datatables adresine gider
    Given kullanıcı new button’a Click eder
    Given kullanici "<firstname>"  firstname girer
    Given kullanici "<lastname>"  lastname girer
    Then kullanici "<position>"  position girer
    Given kullanici "<office>"  office girer
    Given kullanici "<extension>"  extension girer
    Given kullanici "<start_date>"  start_date girer
    Given kullanici "<salary>"  salary girer
    When kullanıcı create buttona click eder
    Then screenshot yap
    And kullanıcı "<firstname>" firstname arar
    Then name fields’in "<firstname>" firstname içerdiğini verify eder


    Examples: test data for the data table test
      | firstname | lastname | position | office | extension | start_date | salary |
      | ali       | veli     | keeper   | Adana  | 120       | 2023-01-30 | 2050   |

  @datatables_data_table
  Scenario: TC02_Testing_Data_Table_with_dataTables
    Given When kullanıcı datatables adresine gider
    Then screenshot yap
    #Given kullanıcı new button’a Click eder
    When kullanıcı tüm fields girer firstname verryf eder
      | firstname | lastname | position | office | extension | start_date | salary |
      | ali1      | veli     | keeper   | Adana  | 120       | 2023-01-30 | 2050   |
      | ali2      | karaal   | defance  | Mus    | 201       | 2023-01-29 | 1455   |
      | ali3      | kar      | libero   | usak   | 302       | 2023-01-28 | 3033   |
    #When kullanıcı create buttona click eder

  @excel_data_tables
  Scenario: TC03_Testing_Data_Table_with_excel
    Given When kullanıcı datatables adresine gider
    Then screenshot yap
   # Given kullanıcı new button’a Click eder
    And kullanıcı excel ile tum field girer verify yapar
    #When kullanıcı create buttona click eder