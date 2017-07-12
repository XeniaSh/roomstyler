package roomstyler.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class PopupForm extends BaseForm{
     private Button btnClosePopin = new Button("xpath=//a[@class=\'popin-close-title\']", "close popin");

    public void closePopup(){
        browser.waitForPageToLoad();
        btnClosePopin.click();
    }

    public PopupForm(){
        super(By.xpath("//a[@class=\"popin-close-title\"]"), "popup");
    }

}
