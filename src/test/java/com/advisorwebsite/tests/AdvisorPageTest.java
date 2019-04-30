package com.advisorwebsite.tests;

import com.advisorwebsite.pages.AdvisorPage;
import com.advisorwebsite.tools.BaseTest;
import com.advisorwebsite.tools.DataForTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvisorPageTest extends BaseTest {
    private AdvisorPage advisorPage;

    @BeforeClass(description = "Create page object instance")
    public void beforeClass() {
        advisorPage = new AdvisorPage(driver);
    }

    @BeforeMethod(description = "Pre condition step - Login page is opened in web browser")
    public void beforeMethod() {
        navigateToUrl(DataForTest.ADVISOR_URL);
    }

    @Test(description = "Test case - TC_09, Login not registered user")
    public void testLoginNotRegisteredUser() {
        //Steps
        advisorPage.typeEmail(DataForTest.TEST_EMAIL);
        advisorPage.typePassword(DataForTest.TEST_PASS);
        advisorPage.clickLoginButton();

        //Verify actual results with expected results
        assertThat(advisorPage.getAlertErrorMessage())
                .as("Alert error message is not displayed above the email input field")
                .contains(DataForTest.ALERT_ERROR_MESSAGE);

        assertThat(advisorPage.getAlertBoxColor())
                .as("Alert message above the email input field is not displayed in red box")
                .isEqualTo(DataForTest.ALERT_BOX_COLOR);

        assertThat(advisorPage.isErrorEmailBoxDisplayed())
                .as("Email input field is not displayed with error border")
                .isTrue();

        assertThat(advisorPage.getEmailBoxBorderColor())
                .as("Border color of email input field box is not red")
                .isEqualTo(DataForTest.EMAIL_BORDER_COLOR);

        assertThat(advisorPage.getFormErrorMessage())
                .as("Form error message is not displayed under the email input field")
                .isEqualTo(DataForTest.LOGIN_ERROR_MESSAGE);
    }

    @Test(description = "Test case - TC_12, Restore password for not registered user")
    public void testRestorePassForNotRegisteredUser() {
        //Steps
        advisorPage.clickForgotPasswordLink();
        advisorPage.typeEmail(DataForTest.TEST_EMAIL);
        advisorPage.clickSubmitButton();

        //Verify actual results with expected results
        assertThat(advisorPage.getAlertErrorMessage())
                .as("Alert error message is not displayed above the email input field")
                .contains(DataForTest.ALERT_ERROR_MESSAGE);

        assertThat(advisorPage.getAlertBoxColor())
                .as("Alert message above the email input field is not displayed in red box")
                .isEqualTo(DataForTest.ALERT_BOX_COLOR);

        assertThat(advisorPage.isErrorEmailBoxDisplayed())
                .as("Email input field is not displayed with error border")
                .isTrue();

        assertThat(advisorPage.getEmailBoxBorderColor())
                .as("Border color of email input field box is not red")
                .isEqualTo(DataForTest.EMAIL_BORDER_COLOR);

        assertThat(advisorPage.getFormErrorMessage())
                .as("Form error message is not displayed under the email input field")
                .isEqualTo(DataForTest.TEST_EMAIL + " " + DataForTest.FORGET_PASS_ERROR_MESSAGE);
    }
}
