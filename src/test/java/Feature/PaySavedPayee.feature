Feature: Pay saved payee


  Scenario: Pay saved successfully

    And Click on the button
      | Button_Pay_Bills |
    And Handle dropdown
      | dropdown_payee      | 1 |
      | dropdown_sp_account | 2 |
    And Enter the value
      | input_sp_amount      | 1000        |
      | input_sp_date        | 11112023    |
      | input_sp_description | hello world |
    And Click on the button
      | button_pay_saved_payees |

    Then Verify this text
      | text_success_message_addNewPayee | The payment was successfully submitted. |


