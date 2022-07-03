package Dev_py;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"wl-login-link ng-scope\"]")
    private WebElement loginButton;

    @FindBy(id = "login_email")
    private WebElement loginInput;

    @FindBy(id = "login_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement runButton;

    @FindBy(id = "login_register_language")
    private WebElement languages;

    @FindBy(xpath = "//form[@name=\"logForm\"]/h3")
    private WebElement headerForm;

    @FindBy(xpath = "//*[contains(text(), 'брокеры')]")
    private WebElement brokersTab;

    @FindBy(xpath = "//*[contains(text(), 'главная')]")
    private WebElement homeTab;

    public WebElement getHomeTab() {
        return homeTab;
    }

    public WebElement getBrokersTab() {
        return brokersTab;
    }


    public WebElement getHeaderForm() {
        return headerForm;
    }

    public HomePage inLoginForm() {
        loginButton.click();
        return this;
    }

    public HomePage inputLoginForm(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage submit() {
        runButton.click();
        return this;
    }

    public HomePage languageSwitching(String language) {
        Select select = new Select(languages);
        select.selectByValue(language);
        return this;
    }

    public HomePage openTab(WebElement tab) {
        tab.click();
        return this;
    }
}
