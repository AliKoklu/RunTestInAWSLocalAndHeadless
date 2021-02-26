Feature: Add New payee


  Scenario: Transfer Funds success

    And Click on the button
      | Button_Pay_Bills     |
      | Button_Add_New_Payee |
    And Enter the value
      | input_Payee_Name           | Ali Koklu           |
      | input_np_new_payee_address | 123 main New jersey |
      | input_np_new_payee_account | 1234567890          |
      | input_np_new_payee_details | have fun            |

    And Click on the button
      | Button_add_inthe_new_payee |

    Then Verify this text
      | text_success_message_addNewPayee | was successfully created. |