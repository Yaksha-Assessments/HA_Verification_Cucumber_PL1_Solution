
package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.VerificationPage_PL1;

public class VerificationStep_PL1 extends TestBase {

	VerificationPage_PL1 verification = new VerificationPage_PL1(driver);

	String requisitionNumber = "";

	LocalDate currentDate = LocalDate.now();
	LocalDate date7DaysAgo = currentDate.minusDays(90);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String toDate = currentDate.format(formatter);
	String fromDate = date7DaysAgo.format(formatter);

	@When("Login in the healthapp application")
	public void login_in_the_healthapp_application() {
		verification.login();
	}

	@Given("Scroll & click till {string} menu on the side bar.")
	public void scroll_click_till_menu_on_the_side_bar(String string) {
		verification.openVerificationMenu();
	}

	@Then("Verify that the user is able to navigate to {string} section")
	public void verify_that_the_user_is_able_to_navigate_to_section(String module) throws InterruptedException {
		verification.successfullNavigation(module);
	}

	@Then("Verify that the {string} menu is visible.")
	public void verify_that_the_menu_is_visible(String module) {

	}

	@Then("Verify that {string} button is visible.")
	public void verify_that_buttons_are_visible(String text) {
		verification.verifyButtonPresentWithText(text);
	}

	@Then("Click on {string} under {string}")
	public void click_on_under(String subModule, String module) {
		verification.clickOnButtonByText(module);
		verification.clickOnButtonByText(subModule);
	}

	@When("Choose the date from Jan 2020 to March 2024")
	public void choose_date() {

		verification.chooseDate(fromDate, toDate);
	}

	@When("Click on tooltip button")
	public void click_tooltip() {
		verification.clickTooltip();
	}

	@When("Click on OK button")
	public void click_ok() {
		verification.clickOkButton();
	}

	@When("Select {string} option from the date range dropdown")
	public void date_range(String range) {
		verification.chooseDateRange(range);
	}

	@Given("I am on the required page")
	public void i_am_on_the_required_page() {

	}

	@Then("Verify these elements are visible on the page Requisition, Purchase Request, Purchase Order, GR Quality Inspection, Ok, print, First, Previous, Next, Last, view, search bar, Requisition Status, Date range, Pending, Approved, Rejected")
	public void verifyElementsArePresentOnThePage() throws Exception {
		Assert.assertTrue(verification.verifyVerificationComponentsAreVisible());
	}

	@Then("Click on {string} tab")
	public void click_on_tab(String text) {
		verification.clickOnButtonByText(text);
	}

	@Then("Verify that all the dates present inside the requested date are within the range")
	public void verify_that_all_the_dates_present_inside_the_requested_date_are_within_the_range()
			throws InterruptedException {
		LocalDate currentDate = LocalDate.now();
		LocalDate date7DaysAgo = currentDate.minusDays(90);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = currentDate.format(formatter);
		String fromDate = date7DaysAgo.format(formatter);
		Thread.sleep(3000); // Waiting for data to load
		verification.verifyDateRange(fromDate, toDate);
	}

	@Then("Click on the {string} Radio button from List by Verification Status")
	public void click_on_the_radio_button_from_list_by_verification_status(String radioButtonText) {
		Assert.assertTrue(verification.selectRadioButton(radioButtonText));
	}

	@When("Choose {string} option from requistion status dropdown")
	public void choose_requistion_status(String status) throws InterruptedException {
		verification.chooseReqStatus(status);
	}

	@Then("Verify that the choosen option is {string}")
	public void verify_that_the_choosen_option_is_active(String status) {
		verification.verifyReqStatus(status);
	}

	@When("Fetch the requisition Id & Click on View button from the first row of requisition data")
	public void fetch_requisition_num() {
		requisitionNumber = verification.fetchReqNum();
	}

	@When("Verify the requisition Id")
	public void verify_req_id() {
		verification.verifyReqNum(requisitionNumber);
	}

	@Then("Fetch the total count and check if it matches with total items displayed")
	public void verify_total_count() throws InterruptedException {
		Thread.sleep(3000);
		verification.verifyCount();
	}

	@Then("Verify that the date range remains the same")
	public void verify_desired_date_range() {
		verification.verifyDateRangeforReq(fromDate, toDate);
	}

	@Then("Verify Pending radio button is visible")
	public void verify_pending_radio_button_is_visible() throws Exception {
		Assert.assertTrue(verification.isPendingRadioButtonVisible());
	}

	@When("Scroll all the way to the bottom of the page")
	public void scroll_all_the_way_to_the_bottom_of_the_page() throws Exception {
		Assert.assertTrue(verification.scrollAllTheWayDown());
	}

	@Then("Verify Previous button is visible")
	public void verify_previous_button_is_visible() throws Exception {
		Assert.assertTrue(verification.isPreviousButtonVisible());
	}

	@Then("Scroll all the way to the top of the page")
	public void scroll_all_the_way_to_the_top_of_the_page() throws Exception {
		Assert.assertTrue(verification.scrollAllTheWayUp());
	}

	@Given("Navigate to the Internal section under Inventory")
	public void navigate_to_the_section_under_inventory() {
		verification.clickOnInventory();
	}

	@When("Click on Purchase Request")
	public void click_on_purchase_request() {
		verification.clickOnPurchaseRequest();
	}

	@When("Click on the Create Purchase Request button")
	public void click_on_the_button_create_purchase_request() {
		verification.clickOnCreatePurchaseRequestButton();
	}

	@When("Click on the Request button")
	public void click_on_the_Request_button() {
		verification.clickOnRequestButton();
	}

	@Then("Verify error message as {string} is displayed")
	public void verify_error_message_as_is_displayed(String string) {
		Assert.assertEquals(verification.verifyRequiredFieldErrormessage(), "Item is required");
	}

	@Then("Hover on the star and Verify tooltip text as {string}")
	public void hover_on_the_star_and_verify_tooltip_text_as_remember_this_date(String tooltipText) {
		Assert.assertEquals(verification.verifyToolTipText(), tooltipText);
	}

}
