package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.pages.FavouritesPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FavouritesSteps extends WebDriverTestCase{

	FavouritesPage favouritesPage=new FavouritesPage();
	@QAFTestStep(description = "user navigates to favourite section and clicks on ViewAll")
	public void user_goes_to_favourite_section_and_clicks_on_view_all() throws Exception{
		favouritesPage.clickViewAll();
	}
	@QAFTestStep(description = "user is able to view the list of Favourites")
	public void user_should_able_to_see_all_the_favourites() throws Exception{
		favouritesPage.verifyAllFavouritesText();
	}

	@QAFTestStep(description = "user select any favourites from the list and clicks on Delete")
	public void user_select_any_favourites_from_the_list_and_clicks_on_delete() throws Exception {
		favouritesPage.deleteanyFavourite();
	}
	@QAFTestStep(description = "user confirm to click on Delete")
	public void user_confirm_to_click_on_delete()throws Exception {
		favouritesPage.clickConfirmDelete();
	}

	@QAFTestStep(description="user verify delete toast message displayed in the page")
	public void userVerifyDeleteToastMessageDisplayedInThePage()throws Exception{
		favouritesPage.verifyRemovedToastMessage();
	}

	@QAFTestStep(description="user goes to Recent activity section and clicks on Successful link")
	public void userGoesToRecentActivitySectionAndClicksOnSuccessfulLink() throws Exception{
		favouritesPage.clickSuccessfullink();
	}
	@QAFTestStep(description="clicks on Beneficiary Tab")
	public void clicksOnBeneficiaryTab() throws Exception{
		favouritesPage.clickBeneficiaryTab();
	}
	@QAFTestStep(description="user select any Beneficiary from the list and clicks on Star mark")
	public void userSelectAnyBeneficiaryFromTheListAndClicksOnStarMark()throws Exception
	{
		favouritesPage.markasFavourite();
	}
	@QAFTestStep(description="user select any  Favourite Vendor and clicks on Star mark{0}")
	public void unmarkFavourite(Map<String,String> vendorlist)throws Exception
	{
		favouritesPage.markasFavouriteVendor(vendorlist);
	}
	@QAFTestStep(description="user select any Vendor and clicks on Star mark") 
	public void userSelectAnyVendorAndClicksOnStarMark()throws Exception
	{ 
		favouritesPage.markasFavourite();
	}
	@QAFTestStep(description="user select any Favourite Vendor and clicks on Star mark")
	public void userSelectAnyFavouriteVendorAndClicksOnStarMark()throws Exception{
		favouritesPage.markasUnFavourite();
	}

	@QAFTestStep(description="user select any Favourite Beneficiary and clicks on Star mark")
	public void userSelectAnyFavouriteBeneficiaryAndClicksOnStarMark()throws Exception{
		favouritesPage.markasUnFavourite();
	}
	@QAFTestStep(description="user select any favourite vendor from the list and capture transaction details")
	public void userSelectAnyFavouriteVendorFromTheListAndCaptureTransactionDetails()throws Exception{
		favouritesPage.VendorTransactionDetails();
	}
	@QAFTestStep(description="user Should able mark as favourite and also verify toast message displayed in the page")
	public void userShouldAbleMarkAsFavouriteAndAlsoVerifyToastMessageDisplayedInThePage()throws Exception{
		favouritesPage.verifyAddedToastMessage();
	}
	@QAFTestStep(description="user select any Vendor from the list and clicks on Pay Button")
	public void userSelectAnyVendorFromTheListAndClicksOnPayButton()throws Exception{
		favouritesPage.makePayment();
	}

	@QAFTestStep(description="user select any Favourite from the list and clicks on Pay Button")
	public void userSelectAnyFavouriteFromTheListAndClicksOnPayButton()throws Exception{
		favouritesPage.selectFavourite();
	}
	@QAFTestStep(description="user verify prepopulated details are filled or not in the page")
	public void userVerifyPrepopulatedDetailsAreFilledOrNotInThePage() throws Exception{
		favouritesPage.verifyPrefilledDetails();
	}
	@QAFTestStep(description="user fills all the remaining details and clicks on make payment{0}")
	public void userFillsAllTheRemainingDetailsAndClicksOnMakePayment(List<Map<String, String>> paymentdetails)throws Exception{
		favouritesPage.enterPaymentDetails(paymentdetails);
	}
	@QAFTestStep(description="user verify fund transfer toast message displayed in the page")
	public void userVerifyFundTransferToastMessageDisplayedInThePage() throws Exception{
		favouritesPage.verifyfundTransferText();
	}
	@QAFTestStep(description="user able to edit payment details and clicks on make payment{0}")
	public void userAbleToEditPaymentDetailsAndClicksOnMakePayment(List<Map<String, String>> paymentdetails)throws Exception{
		favouritesPage.editPaymentDetails(paymentdetails);
	}
	@QAFTestStep(description="user Should able unmark as favourite and also verify toast message displayed in the page")
	public void userShouldAbleUnmarkAsFavouriteBeneficiaryAndAlsoVerifyToastMessageDisplayedInThePage()throws Exception{
		favouritesPage.verifyRemovedToastMessage();
	}
	@QAFTestStep(description="user select any Beneficiary from the list and clicks on Pay Button")
	public void userSelectAnyBeneficiaryFromTheListAndClicksOnPayButton()throws Exception{
		favouritesPage.makePayment();
	}
	@QAFTestStep(description="user fills all the details and clicks on make payment{0}")
	public void userFillsBeneficiaryPaymentDetails(List<Map<String, String>> paymentdetails)throws Exception
	{
		favouritesPage.enterBeneficiaryPaymentDetails(paymentdetails);

	}
	@QAFTestStep(description="user clicks on Add to Favourites checkbox")
	public void userClicksOnAddToFavouritesCheckbox()throws Exception{
		favouritesPage.clickFavouitesCheckbox();
	}
}