package test.runner;

import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import setup.BrowserSetup;

public class AdminDashboardTestCase extends BrowserSetup {
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @Test(priority = 3, description = "verify invalid search validation", groups = {"regression", "smoke"})
    public void searchValidation() {
        adminDashboardPage.invalidSearching();
    }

    @Test(priority = 1, description = "verify user can update name", groups = {"regression", "smoke"})
    public void updatingUserDetails() throws InterruptedException {
        adminDashboardPage.editUserDetails();
    }

    @Test(priority = 2, description = "verify user can delete a user", groups = {"regression", "smoke"})
    public void userDelete() {
        adminDashboardPage.deleteUser();
    }

    @Test(priority = 4, description = "verify user can logout", groups = {"regression", "smoke"})
    public void userLogout() {
        adminDashboardPage.logout();
    }

    @Test(priority = 4, description = "verify user can search by email", groups = {"regression", "smoke"})
    public void userSearch() {
        adminDashboardPage.searchByEmail();
    }
}
