package roomstyler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import roomstyler.entities.Item;
import roomstyler.forms.PopupForm;
import roomstyler.forms.Roomstyler3dForm;
import roomstyler.menus.Menu;
import webdriver.BaseTest;


public class RoomstylerTest extends BaseTest {

	public void runTest(){
        PopupForm popupForm = new PopupForm();
        popupForm.closePopup();

        Roomstyler3dForm roomstyler3dForm = new Roomstyler3dForm();
        roomstyler3dForm.getMenu().navigateMenu(Menu.MenuItem.FURNISH, Menu.SubMenuItem.DINING_ROOM);

        Item item = new Item();
        roomstyler3dForm.moveItem(item);
        Assert.assertTrue(roomstyler3dForm.trueItem(item));
        roomstyler3dForm.checkItem(item);
        Assert.assertNotNull(item.checkNotEmptyParameters());
        roomstyler3dForm.deleteItem(item);
        Assert.assertTrue(roomstyler3dForm.checkItemsInfo());
        roomstyler3dForm.leave(item);
    }
}
