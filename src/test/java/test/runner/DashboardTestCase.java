package test.runner;

import org.testng.annotations.Test;
import pages.DashboardPage;
import setup.BrowserSetup;

public class DashboardTestCase extends BrowserSetup {
    DashboardPage dashboardPage;

    @Test(priority = 3, description = "verify invalid search validation", groups = {"regression", "smoke"})
    public void searchValidation() {
        dashboardPage.invalidSearching();
    }

    @Test(priority = 1, description = "verify user can update name", groups = {"regression", "smoke"})
    public void updatingUserDetails() throws InterruptedException {
        dashboardPage = new DashboardPage();
        dashboardPage.editUserDetails();
    }

    @Test(priority = 2, description = "verify user can delete a user", groups = {"regression", "smoke"})
    public void userDelete() {
        dashboardPage.deleteUser();
    }


    @Test(priority = 4, description = "verify user can logout", groups = {"regression", "smoke"})
    public void userLogout() {
        dashboardPage.logout();
    }
}
