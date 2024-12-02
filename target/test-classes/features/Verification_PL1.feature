Feature: Verification Module

  Background: User Signup
    When Login in the healthapp application

  @TC_1
  Scenario: Verify the verfication module is present or not
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section

  @TC_2
  Scenario: Verify all sub-modules are displayed correctly after Clicking on the "verification" Module.
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    Then Verify that "Inventory" button is visible.
    Then Verify that "Pharmacy" button is visible.

  @TC_3
  Scenario: Verify the presence of Requisition tab in inventory section with all fields.
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    Then Verify that "Inventory" button is visible.
    Then Verify that "Pharmacy" button is visible.
    And Click on "Requisition" under "Inventory"
    Then Verify these elements are visible on the page Requisition, Purchase Request, Purchase Order, GR Quality Inspection, Ok, print, First, Previous, Next, Last, view, search bar, Requisition Status, Date range, Pending, Approved, Rejected

  @TC_4
  Scenario: Verify to navigate on another sub module after open the inventory module
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Pharmacy" tab
    Then Verify that the user is able to navigate to "Verification/Pharmacy/" section

  @TC_5
  Scenario: Verify to navigate on another sub tab after open the Requisition tab
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Purchase Order" under "Inventory"
    Then Verify that the user is able to navigate to "Verification/Inventory/PurchaseOrder" section

  @TC_6
  Scenario: Verify to search the data by picking the date filter
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the "Verification" menu is visible.
    And Choose the date from Jan 2020 to March 2024
    And Click on the "all" Radio button from List by Verification Status
    And Click on OK button
    Then Verify that all the dates present inside the requested date are within the range

  @TC_7
  Scenario: Verify the tooltip and it's text present on hover the mouse on "Star"
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the "Verification" menu is visible.
    Then Hover on the star and Verify tooltip text as "Remember this Date"

  @TC_8
  Scenario: Verify dates are remembered correclty
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Choose the date from Jan 2020 to March 2024
    And Click on tooltip button
    And Click on OK button
    And Click on "Pharmacy" tab
    And Click on "Inventory" tab
    Then Verify that the date range remains the same

  @TC_9
  Scenario: Verify data range by Select "one week" option from drop down
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Select 'Last 1 Week' option from the date range dropdown
    And Click on OK button
    Then Verify that all the dates present inside the requested date are within the range

  @TC_10
  Scenario: Verify following radio buttons are selectable:Pending, Approved, Rejected & All
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on the "pending" Radio button from List by Verification Status
    And Click on the "pending" Radio button from List by Verification Status
    And Click on the "approved" Radio button from List by Verification Status
    And Click on the "approved" Radio button from List by Verification Status
    And Click on the "rejected" Radio button from List by Verification Status
    And Click on the "rejected" Radio button from List by Verification Status
    And Click on the "all" Radio button from List by Verification Status
    And Click on the "all" Radio button from List by Verification Status
    And Click on the "pending" Radio button from List by Verification Status

  @TC_11
  Scenario: Verify to filter the records by Select active drop down from Requisition Status
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Choose "active" option from requistion status dropdown
    Then Verify that the choosen option is 'active'

  @TC_12
  Scenario: Verify the presence of view button
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on the "all" Radio button from List by Verification Status
    And Choose "active" option from requistion status dropdown
    And Choose the date from Jan 2020 to March 2024
    And Click on OK button
    And Fetch the requisition Id & Click on View button from the first row of requisition data
    Then Verify the requisition Id

  @TC_13
  Scenario: Verify Record Count Matches in Purchase Request
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Purchase Request" under "Inventory"
    And Choose the date from Jan 2020 to March 2024
    And Click on the "all" Radio button from List by Verification Status
    And Click on OK button
    Then Fetch the total count and check if it matches with total items displayed

  @TC_14
  Scenario: Verify scrolling of page
    Given Scroll & click till "Verification" menu on the side bar.
    Then Verify that the user is able to navigate to "Verification" section
    And Click on "Purchase Request" under "Inventory"
    Then Verify Pending radio button is visible
    And Scroll all the way to the bottom of the page
    Then Verify Previous button is visible
    And Scroll all the way to the top of the page
    Then Verify Pending radio button is visible

  @TC_15
  Scenario: Verify the required "Item" field in the Purchase Request section under the Inventory module.
    Given Navigate to the Internal section under Inventory
    And Click on Purchase Request
    And Click on the Create Purchase Request button
    And Click on the Request button
    Then Verify error message as "Item is required" is displayed
