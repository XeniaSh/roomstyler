package roomstyler.entities;

public class Item{
    private final String path = "src/test/resources/pic/";
    private final String item = "item.png";
    private final String standardItem = "standard.png";
    private final String deleteItem = "close.png";
    private final String workZoneCenter = "view.png";
    private final String leavePage = "leave.png";
    private String name;
    private String parameters;

    public void setNameAndParameters(String nameToset, String parametersToset){
        name = nameToset;
        parameters = parametersToset;
    }
    public boolean checkNotEmptyParameters(){
        return ((name.length() > 1) && (parameters.length() > 1));
    }
    public String getItemPicture(){
        return path + item;
    }
    public String getWorkzoneCenter(){
        return path + workZoneCenter;
    }
    public String getItemStandard(){
        return path + standardItem;
    }
    public String getItemDelete(){
        return path + deleteItem;
    }
    public String getLeave(){
        return path + leavePage;
    }
}
