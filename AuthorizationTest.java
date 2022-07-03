import Dev_py.HomePage;
import Dev_py.UserPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.function.BooleanSupplier;

public class AuthorizationTest extends AbstractTest {

    @Test
    public void authorization() {
    HomePage homePage = new HomePage(getWebDriver());
    homePage
            .inLoginForm()
            .inputLoginForm("autotest@dev.ru", "12345678")
            .submit();
        Assertions.assertTrue((BooleanSupplier) new UserPage(getWebDriver()).getBurgerMenu());
    }

    @Test
    public void languageSwitching() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage
                .inLoginForm()
                .languageSwitching("en");
        Assertions.assertEquals(homePage.getHeaderForm().getText(), "Login");
    }

    @Test
    public void openBrokersTab() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.openTab(homePage.getBrokersTab());
        Assertions.assertTrue(getWebDriver().findElements(
                By.xpath("//a[@ui-sref=\"menuLayout.connectTraderView({id: broker.id})\"]")).size() > 1);
    }

    @Test
    public void openHomeTab() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.openTab(homePage.getHomeTab());
        Assertions.assertEquals(getWebDriver().getCurrentUrl(), "https://www.jivestor.com/");
    }
}
