Feature: Transfer


  Scenario: Transfer Funds success

    And Click on the button
      | button_Transfer_Funds |

    And Handle dropdown
      | dropdown_tf_fromAccountId |2 |
      | dropdown_tf_toAccountId   |3 |

    And Enter the value
      | input_tf_amount | 1000 |

    And Click on the button
      | button_btn_submit |

    And Click on the button
      | button_btn_submit |

    Then Verify this text
      | text_Success_message | You successfully submitted your transaction. |


