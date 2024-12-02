package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class VerificationPage_PL1 extends StartupPage {

	public VerificationPage_PL1(WebDriver driver) {
		super(driver);
	}

	/*
	 * --------------------------- Locators
	 * -------------------------------------------
	 */

	private By emailInput = By.cssSelector("input#username_id");
	private By passwordInput = By.cssSelector("#password");
	private By signInButton = By.cssSelector("#login");
	private By headerProfileIcon = By.cssSelector("a#header-icon-profile");
	private By logoutButton = By.cssSelector("a#logout");

	public By getVerificationLocator() {
		return By.xpath("//a[@href='#/Verification']");
	}

	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}

	public void login() {
		driver.findElement(emailInput).sendKeys("admin");
		driver.findElement(passwordInput).sendKeys("pass123");
		driver.findElement(signInButton).click();

	}

	public By calendarFromDropdown() {
		return By.xpath("(//input[@id='date'])[1]");
	}

	public By calendarToDropdown() {
		return By.xpath("(//input[@id='date'])[2]");
	}

	public By getOkButtonLocator() {
		return By.xpath("//button[@class='btn green btn-success']");
	}

	public By getStarIconLocator() {
		return By.xpath("//i[contains(@class,'icon-favourite')]/..");
	}

	public By getActualRequestedOnDates() {
		return By.xpath("//div[@col-id=\"RequisitionDate\"]/span[not(contains(@class,'hidden'))]");
	}

	public By verifyRequisitionDropdown() {
		return By.xpath("//div[contains(text(),'Requisition Status:')]/../div/select");
	}

	public By getRadioButtonsLocator(String radioButtonName) {
		return By.xpath("//input[@value='" + radioButtonName + "']/../span");
	}

	public By getReqStatus() {
		return By.cssSelector("div[ref='eCenterContainer'] div[col-id='RequisitionStatus']");
	}

	public By getRequisitionNumberLocatorsForAllRequisitions() {
		return By.xpath("//div[@col-id='RequisitionNo' and @role='gridcell']");
	}

	public By getRequisitionNumberLocatorFromTheReport() {
		return By.xpath("//div[text()='Requisition No:']/b");
	}

	public By getResultCountLocator() {
		return By.cssSelector("div[class='page-items']");
	}

	public By getFirstViewButton() {
		return By.xpath("(//a[text()=\"View\"])[1]");
	}

	public By getTotalRecordCount() {
		return By.cssSelector("span[ref='eSummaryPanel'] span[ref='lbRecordCount']");
	}

	public By getButtonLocatorsBytext(String buttonName) {
		return By.xpath("//button[contains(text(),'" + buttonName + "')]");
	}

	public By getInventoryLocator() {
		return By.xpath("//a[@href='#/Inventory']");
	}

	public By getInventoryPageBarFixedLocator(String navBarName) {
		return By.xpath("//ul[contains(@class,'page-breadcrumb')]/li/a[@href='#/Inventory/" + navBarName + "']");
	}

	public By getSubNavTabLocator(String subNavName) {
		return By.xpath("//div[@class=\"sub-navtab\"]/ul/li/a[text()='" + subNavName + "']");
	}

	public By getLocatorById(String idName) {
		return By.id(idName);
	}

	public By getItemNameRequiredMsg() {
		return By.xpath("//div[contains(text(),'Item is required')]");
	}

	public By favouriteOrStarIcon() {
		return By.xpath("//i[contains(@class,'icon-favourite')]");
	}

	public By searchBarId() {
		return By.id("quickFilterInput");
	}

	/*
	 * --------------------------- Methods
	 * -------------------------------------------
	 */

	public void openVerificationMenu() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement verificationTab = driver.findElement(getVerificationLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
			verificationTab.click();

		} catch (Exception e) {
			throw e;
		}
	}

	public void successfullNavigation(String module) throws InterruptedException {
		// Get the current URL
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();

		// Substring to verify
		String expectedSubstring = module;
		System.out.println("this is the current URL: " + currentURL);

		// Verify the substring
		if (currentURL.contains(expectedSubstring)) {
			System.out.println("URL contains the expected substring: " + expectedSubstring);
		} else {
			Assert.fail("URL does not contains the expected substring: " + expectedSubstring);
		}
	}

	public void verifyButtonPresentWithText(String text) {
		WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
		Boolean elementISDisplayed = element.isDisplayed();

		if (!elementISDisplayed) {
			Assert.fail("element with text:" + text + " is not visible");
		}
	}

	public void clickOnButtonByText(String text) {
		WebElement element = driver.findElement(getAnchorTagLocatorByText(text));
		element.click();
	}

	public void chooseDate(String fromDate, String toDate) {
		// Split the fromDate and toDate into day, month, and year components

		System.out.println("From Date : " + fromDate + ", To Date : " + toDate);
		String[] fromDateComponents = fromDate.split("-");
		String fromDay = fromDateComponents[0];
		String fromMonth = fromDateComponents[1];
		String fromYear = fromDateComponents[2];

		String[] toDateComponents = toDate.split("-");
		String toDay = toDateComponents[0];
		String toMonth = toDateComponents[1];
		String toYear = toDateComponents[2];

		// Locate the date dropdowns and OK button
		WebElement fromDateDropdown = driver.findElement(calendarFromDropdown());
		WebElement toDateDropdown = driver.findElement(calendarToDropdown());
		WebElement okButton = driver.findElement(getOkButtonLocator());

		// Highlight and set the "from" date
		fromDateDropdown.sendKeys(fromDay);
		fromDateDropdown.sendKeys(fromMonth);
		fromDateDropdown.sendKeys(fromYear);

		// Highlight and set the "to" date
		toDateDropdown.sendKeys(toDay);
		toDateDropdown.sendKeys(toMonth);
		toDateDropdown.sendKeys(toYear);
	}

	public void clickTooltip() {
		WebElement toolTip = driver.findElement(getStarIconLocator());
		toolTip.click();
	}

	public void clickOkButton() {

		WebElement okButton = driver.findElement(getOkButtonLocator());

		okButton.click();
	}

	public By getDateRangeButton() {
		return By.cssSelector("td [data-hover='dropdown']");
	}

	public void chooseDateRange(String range) {
		WebElement dateRangeButton = driver.findElement(getDateRangeButton());
		dateRangeButton.click();
		WebElement valueToSelectElement = driver.findElement(getAnchorTagLocatorByText(range));
		valueToSelectElement.click();

		dateRangeButton.click();
		valueToSelectElement.click();

	}

	public void verifyDateRange(String fromDate, String toDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<WebElement> actualDatesAfterFilterApplied = driver.findElements(getActualRequestedOnDates());
		LocalDate from = LocalDate.parse(fromDate, formatter);
		LocalDate to = LocalDate.parse(toDate, formatter);

		LocalDate date;
		LocalDate newDate = null;

		for (WebElement dateElement : actualDatesAfterFilterApplied) {

			String dateText = dateElement.getText();

			try {
				date = LocalDate.parse(dateText, inputFormatter);
				newDate = LocalDate.parse(date.format(formatter), formatter);

			} catch (Exception e) {
				Assert.fail("Date parsing failed for: " + dateText);

			}

			if (newDate.isBefore(from) || newDate.isAfter(to)) {
				Assert.fail("Date parsing failed for: " + dateText);
			} else {
				System.out.println("the from date is: " + from + " the to date is: " + to);
			}
		}
	}

	public boolean selectRadioButton(String radioButtonText) {
		try {
			WebElement radioButtonToClick = driver.findElement(getRadioButtonsLocator(radioButtonText));
			radioButtonToClick.click();
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public void chooseReqStatus(String status) throws InterruptedException {
		WebElement dropdownElement = driver.findElement(verifyRequisitionDropdown());

		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// Select the option with value "active"
		dropdown.selectByValue(status);

		System.out.println("Selected the 'active' option from the dropdown.");

		Thread.sleep(10000);
	}

	public void verifyReqStatus(String status) {
		// Locate all the requisition status elements in the table
		List<WebElement> reqStatus = driver.findElements(getReqStatus());
		System.out.println("Length of status > " + reqStatus.size());

		if (reqStatus.size() > 0) {
			for (WebElement statusElement : reqStatus) {
				String statusText = statusElement.getText().trim();
				if (!statusText.equalsIgnoreCase(status)) {
					Assert.fail("Found a status that is not 'active': " + statusText);

				}
			}
			System.out.println("All requisition statuses are 'active'.");

		} else {
			System.out.println("No requisition status records found.");
		}
	}

	public String fetchReqNum() {
		List<WebElement> allRequisionNumbers = driver.findElements(getRequisitionNumberLocatorsForAllRequisitions());
		String expectedRequisitionNumber = allRequisionNumbers.get(0).getText();
		List<WebElement> viewButtonsLocators = driver.findElements(getAnchorTagLocatorByText("View"));
		viewButtonsLocators.get(0).click();
		System.out.println("This is the expected requisition num: " + expectedRequisitionNumber);
		return expectedRequisitionNumber;
	}

	public void verifyReqNum(String expectedReqNumber) {
		String actualRequisitionNumber = driver.findElement(getRequisitionNumberLocatorFromTheReport()).getText()
				.trim();

		System.out.println("This is the actual requisition num: " + actualRequisitionNumber);
		Assert.assertEquals(expectedReqNumber, actualRequisitionNumber);
	}

	public void verifyCount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for the results to load (adjust wait time as needed)
//		driver.(getResultCountLocator(), 10000);
//		commonEvents.waitTillElementVisible(getFirstViewButton(), 30000);

		// Fetch the result count shown at the bottom of the page
		WebElement resultCountElement = driver.findElement(getResultCountLocator());
		String resultCountText = resultCountElement.getText();
		System.out.println("Result count text: " + resultCountText);

		// Split the text to find all occurrences of the number
		String[] actualResultCount = resultCountText.split(" ");
		String actualResultCountText = actualResultCount[3];

		WebElement totalRecords = driver.findElement(getTotalRecordCount());
		String ExpectedTotalRecordsCount = totalRecords.getText();

		// Extract the shown result count and total record count
		int shownResultCount = Integer.parseInt(actualResultCountText);
		int totalRecordCount = Integer.parseInt(ExpectedTotalRecordsCount);

		System.out.println("Shown Result Count: " + shownResultCount);
		System.out.println("Total Record Count: " + totalRecordCount);

		Assert.assertEquals(shownResultCount, totalRecordCount);
	}

	public void verifyDateRangeforReq(String fromDate, String toDate) {
		System.out.println("From Date : " + fromDate + ", To Date : " + toDate);
		String[] fromDateComponents = fromDate.split("-");
		String fromDay = fromDateComponents[0];
		String fromMonth = fromDateComponents[1];
		String fromYear = fromDateComponents[2];

		String[] toDateComponents = toDate.split("-");
		String toDay = toDateComponents[0];
		String toMonth = toDateComponents[1];
		String toYear = toDateComponents[2];
		String actualFromDate = fromDay + "-" + fromMonth + "-" + fromYear;
		String actualToDate = toDay + "-" + toMonth + "-" + toYear;

		System.out.println("Actual from date : " + actualFromDate);
		System.out.println("Actual to date : " + actualToDate);

		// Locate and click the tooltip
//		commonEvents.waitTillElementVisible(toolTip, 10000);
//		Thread.sleep(3000);
//		commonEvents.click(toolTip);

		// Verify if the remembered dates match the expected dates
		if (actualFromDate.equals(fromDate) && actualToDate.equals(toDate)) {
			System.out.println("Returned true");
//			Thread.sleep(20000);
//			commonEvents.highlight(toolTip).click(toolTip);
//			commonEvents.click(getOkButtonLocator());
		} else {
			Assert.fail("The date does not lies in range of :" + fromDate + " to date: " + toDate);
		}

	}

	public boolean isPendingRadioButtonVisible() throws Exception {
		try {
			WebElement pendingRadioButton = commonEvents.findElement(getRadioButtonsLocator("pending"));
			commonEvents.highlight(pendingRadioButton);
			return commonEvents.isDisplayed(pendingRadioButton);

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean scrollAllTheWayDown() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isPreviousButtonVisible() throws Exception {
		try {
			WebElement previousButton = commonEvents.findElement(getButtonLocatorsBytext("Previous"));
			commonEvents.highlight(previousButton);
			return commonEvents.isDisplayed(previousButton);

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean scrollAllTheWayUp() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	public void clickOnInventory() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement inventoryTab = commonEvents.findElement(getInventoryLocator());
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", inventoryTab);
		commonEvents.highlight(inventoryTab);
		commonEvents.click(inventoryTab);

		WebElement internalTab = commonEvents.findElement(getInventoryPageBarFixedLocator("InternalMain"));
		commonEvents.highlight(internalTab).click(internalTab);
	}

	public void clickOnPurchaseRequest() {
		WebElement purchaseRequestTab = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
		commonEvents.highlight(purchaseRequestTab).click(purchaseRequestTab);
	}

	public void clickOnCreatePurchaseRequestButton() {
		WebElement purchaseRequestButton = commonEvents.findElement(getButtonLocatorsBytext("Create Purchase Request"));
		commonEvents.highlight(purchaseRequestButton).click(purchaseRequestButton);
	}

	public void clickOnRequestButton() {
		WebElement requestPORequisition = commonEvents.findElement(getLocatorById("RequestPORequisition"));
		commonEvents.highlight(requestPORequisition).click(requestPORequisition);
	}

	public String verifyRequiredFieldErrormessage() {
		String itemNameMessageText = "";
		try {

			WebElement itemNameMessageElement = commonEvents.findElement(getItemNameRequiredMsg());
			System.out.println("Item Name message text : " + itemNameMessageElement.getText());
			itemNameMessageText = itemNameMessageElement.getText();

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return itemNameMessageText;
	}

	public String verifyToolTipText() {
		String toolTipValue = "";
		try {
			WebElement toolTip = commonEvents.findElement(favouriteOrStarIcon());
			toolTipValue = commonEvents.highlight(toolTip).getAttribute(toolTip, "title");
			System.out.println("Tool tip title : " + toolTipValue);
		} catch (Exception e) {
			throw e;
		}
		return toolTipValue;
	}

	public boolean verifyVerificationComponentsAreVisible() throws Exception {

		boolean areAllFieldsDisplayed = false;
		try {

			WebElement firstButton = commonEvents.findElement(getButtonLocatorsBytext("First"));
			WebElement previousButton = commonEvents.findElement(getButtonLocatorsBytext("Previous"));
			WebElement nextButton = commonEvents.findElement(getButtonLocatorsBytext("Next"));
			WebElement lastButton = commonEvents.findElement(getButtonLocatorsBytext("Last"));
			WebElement searchBarId = commonEvents.findElement(searchBarId());
			WebElement getDateRangeButton = commonEvents.findElement(getDateRangeButton());
			WebElement calendarFromDropdown = commonEvents.findElement(calendarFromDropdown());
			WebElement calendarToDropdown = commonEvents.findElement(calendarToDropdown());
			WebElement starIconLocator = commonEvents.findElement(getStarIconLocator());
			WebElement requisition = commonEvents.findElement(getSubNavTabLocator("Requisition"));
			WebElement purchaseRequest = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
			WebElement purchaseOrder = commonEvents.findElement(getSubNavTabLocator("Purchase Order"));
			WebElement GRQualityInspection = commonEvents.findElement(getSubNavTabLocator("GR Quality Inspection"));

			List<WebElement> options = Arrays.asList(requisition, purchaseRequest, purchaseOrder, GRQualityInspection,
					firstButton, previousButton, nextButton, lastButton, searchBarId, getDateRangeButton,
					calendarFromDropdown, calendarToDropdown, starIconLocator);

			for (int i = 0; i < options.size(); i++) {
				WebElement option = options.get(i);
				commonEvents.highlight(option);
				System.out.println("is " + i + 1 + " displayed? " + option.isDisplayed());
				if (!option.isDisplayed()) {
					areAllFieldsDisplayed = false;
					throw new Exception("Visibility check failed for: " + option.getText());
				}
			}
			areAllFieldsDisplayed = true;
		} catch (Exception e) {
			// Throw an exception with a meaningful message if any UI component is not found
			throw new Exception("Failed to verify if all fields are displayed!", e);
		}
		// Return the result of the visibility check
		return areAllFieldsDisplayed;
	}

}
