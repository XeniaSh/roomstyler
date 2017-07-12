package roomstyler.menus;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class Menu extends BaseForm{
    private Button btnMenu = new Button(By.xpath("//li[contains(@data-hash,\".sidebar\")]//a[@title=\"%s\"]"), "menu button");
    private Button btnSubMenu = new Button(By.xpath("//div[@id=\'view-search\']//a[text()=\"%s\"]"), "submenu button");
    private String locator;

    public Menu(){
        super(By.xpath("//li[contains(@data-hash,\".sidebar\")]"), "menu");
    }

    public void navigateMenu(MenuItem menuItem, SubMenuItem subMenuItem){
        locator = btnMenu.getLocator().toString();
        btnMenu.setLocator(String.format(locator, menuItem.getName()));
        btnMenu.click();
        locator = btnSubMenu.getLocator().toString();
        btnSubMenu.setLocator(String.format(locator, subMenuItem.getName()));
        btnSubMenu.click();
    }
    public enum MenuItem{
        BUILD("Build room layout"),
        FURNISH("Furnish your room"),
        DECORATE("Decorate your room"),
        LIGHTS("Manage lights"),
        ITEM_LIST("Populate your list"),
        PROPERTIES("Properties"),
        NEW("New");

        private String name;

        MenuItem(String name){
            this.name = name;
        }
        private String getName(){
            return name;
        }
    }
    public enum SubMenuItem{
        ACCESSORIES("Accessories"),
        ARCHITECTURE("Architecture"),
        BATHROOM("Bathroom"),
        BEDROOM("Bedroom"),
        CHRISTMAS("Christmas"),
        DINING_ROOM("Dining room"),
        DIY("Diy"),
        ELECTRICALS("Electricals"),
        FURNITURE("Furniture"),
        GARDEN_AND_OUTDOOR("Garden & outdoor"),
        GYM("Gym"),
        HOME_ENTERTAINMENT("Home entertainment"),
        HOME_OFFICE("Home office"),
        IRRELEVANT_PRODUCTS("Irrelevant products"),
        KIDS_ROOM("Kids' room"),
        KITCHEN("Kitchen"),
        LIGHTING("Lighting"),
        LIVING_ROOM("Living room"),
        PEOPLE_AND_ANIMALS("People & animals");

        private String name;

        SubMenuItem(String name){
            this.name = name;
        }
        private String getName(){
            return name;
        }
    }
}
