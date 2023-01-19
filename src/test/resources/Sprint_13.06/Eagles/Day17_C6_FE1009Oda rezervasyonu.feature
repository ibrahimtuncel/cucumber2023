#FEATURE: FE1009Oda rezervasyonu
#US100451: Oda rezervasyonu yapmak için tüm zorunlu alanları doldur
#Description:  Manager olarak, bir oda rezervasyonu yapabilmeli
#Acceptance Criteria:
#üGiven kullanici application’in sayfasindadir
#üAnd kullanici manager kullanici bilgilerini girer
#üWhen kullanici login button’una click eder
#üThen default page’in displayed oldugunu verify eder
#-------------------------------------------------------------------------------
#üGiven kullanıcı oda rezervasyon sayfasını yönlendirilir
#üAnd kullanıcı tüm zorunlu alanları girer
#üAnd kullanıcı approved checkbox’a click eder
#üAnd kullanıcı paid check box’a click eder
#üAnd kullanıcı save button’una click eder
#üThen kullanıcı success mesajını verify eder
#Test Data:
#Url: https://qa-environment.resortsline.com/Account/Logon
#Credentials/Kullanici Bilgileri :
#manager, Manager1!
@room_rezarvasyonu
Feature: FE1009_room_rezervasyon

  Scenario: TC01_kullanici_manager_profiliyle_login
    Given kullanici application sayfasindadir
    And kullanici manager kullanici bilgilerini girer
      | username | password  |
      | manager  | Manager1! |

      Then kullanici login buttonuna click eder
      Then kullanici "Hotel Management" oldugunu very eder
      Then screenshot yap

      Scenario: TC02_kullanici_room_reservation_yapacak
        Given kullanıcı oda rezervasyon sayfasını yönlendirilir
        Then screenshot yap

      Scenario: : TC03_kullanici_bilgilerini_girer
      And kullanıcı tum zorunlu alanları girer
        | IDHotelDropDown | IDHotelRoomDropDown | Price | dateStart  | dateEnd    | adultAmount | childAmount | nameSurname | phone          | email          | notes              |verryf |
        | manager         | ali                 | 700   | 01/25/2023 | 01/29/2023 | 2           | 2           | test        | (850) 258-2565 | test@gmail.com | dataTable ilk test |RoomReservation was inserted successfully |

        And kullanıcı approved checkbox’a click eder
        And kullanıcı paid check box’a click eder
        And kullanıcı save button’una click eder
        Then screenshot yap
        Then kullanıcı success mesajını verify eder


