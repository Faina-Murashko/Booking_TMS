Feature: Search Hotel Vagar in Faroe islands

  Scenario: search hotel in Faroe islands using the site Booking.com
    Given name hotel in island "Hotel Vagar"
    When user opened hotel page
    Then check first title hotel name is "Hotel Vagar"