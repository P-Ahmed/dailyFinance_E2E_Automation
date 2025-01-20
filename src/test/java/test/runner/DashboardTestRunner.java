package test.runner;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.BrowserSetup;

public class DashboardTestRunner extends BrowserSetup {
    DashboardPage dashboardPage;

    @Test(priority = 3, description = "verify invalid search validation")
    public void searchValidation() {
        dashboardPage.invalidSearching();
    }

    @Test(priority = 1, description = "verify user can update name")
    public void updatingUserDetails() throws InterruptedException {
        dashboardPage = new DashboardPage();
        dashboardPage.editUserDetails();
    }

    @Test(priority = 2, description = "verify user can delete a user")
    public void userDelete() {
        dashboardPage.deleteUser();
    }


    @Test(priority = 4, description = "verify user can logout")
    public void userLogout() {
        dashboardPage.logout();
    }
}
