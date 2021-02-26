Feature: Purchase Foreign Currency

  Scenario: Purchase Foreign Currency

    And Click on the button
      | Button_Pay_Bills                 |
      | Button_Purchase_Foreign_Currency |
    And Handle dropdown
      | dropdown_pc_currency | 1 |
    And Enter the value
      | input_pc_amount | 1000 |
    And Click on the button
      | radioButton_pc_inDollars_true |
      | button_purchase_cash          |
    Then Verify this text
      | text_success_message_addNewPayee | Foreign currency cash was successfully purchased. |
