package roomstyler.forms;

import org.openqa.selenium.*;
import roomstyler.entities.Item;
import roomstyler.menus.Menu;
import webdriver.BaseForm;
import org.sikuli.script.*;
import webdriver.elements.TextBox;
import java.util.ArrayList;
import java.util.List;

public class Roomstyler3dForm extends BaseForm{
    private Location dropRegion = new Location(200, 200);
    private TextBox itemName = new TextBox("xpath=//div[@class='main']//p[@class='name']", "name");
    private TextBox itemParameters = new TextBox("xpath=//div[@class='main']/following-sibling::p[@class='dimensions']", "parameters");
    private List<String> itemsInformation = new ArrayList<String>();
    private TextBox information = new TextBox("xpath=//li[contains(text(),\"Total items in scene\")]//b", "info");
    private boolean informationBoolean = true;
    Region region = new Screen();
    private String itemInfoValue = "0";

    public void moveItem(Item item){
        App.focus(browser.getDriver().getCapabilities().getBrowserName());
        try {
            Match workZoneCenter = region.find(item.getWorkzoneCenter());
            dropRegion = new Location(workZoneCenter.getX() + dropRegion.x, workZoneCenter.getY() + dropRegion.y);
            region.dragDrop(item.getItemPicture(),dropRegion);
        } catch (FindFailed e){e.printStackTrace();}
    }

    public void checkItem(Item item){
        try {
            region.click(item.getItemStandard());
            browser.waitForPageToLoad();
            item.setNameAndParameters(itemName.getText(), itemParameters.getText());
        } catch (FindFailed e){e.printStackTrace();}
    }
    public void deleteItem(Item item){
        try {
            region.click(item.getItemDelete());
        } catch (FindFailed e){e.printStackTrace();}
    }
    public boolean checkItemsInfo(){
        browser.waitForPageToLoad();
        itemsInformation = information.getTextboxTextArray();
        for (int i = 0; i < itemsInformation.size(); i++) {
            if (!itemsInformation.get(i).equals(itemInfoValue)) informationBoolean = false;
        }
        return informationBoolean;
    }
    public Boolean trueItem(Item item){
        try{
             return (region.find(item.getItemStandard()) != null);
        } catch (FindFailed e){e.printStackTrace();}
        return false;
    }

    public void leave(Item item){
        try{
            region.find(item.getLeave());
        } catch (FindFailed e){e.printStackTrace();}
    }
    public Roomstyler3dForm(){
        super(By.xpath("//li[contains(@data-hash,'.sidebar')]"), "roomstyler");
    }

    public Menu getMenu(){
        return new Menu();
    }
}
