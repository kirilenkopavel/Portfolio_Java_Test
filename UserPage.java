package Dev_py;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends AbstractPage {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"open-menu-user\"]")
    private WebElement burgerMenu;

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }
}
