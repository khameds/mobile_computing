package smail.tp1;

import java.util.ArrayList;
import java.util.List;

public class DataManager
{
    private static DataManager INSTANCE;




    private List<String> nameList;

    public void addName(String name) {
        this.nameList.add(name);
    }

    public List<String> getNameList() {
        return nameList;
    }


    private DataManager()
    {
        nameList = new ArrayList<>();
    }

    public static DataManager getDataManager()
    {
        if(INSTANCE == null)
            INSTANCE = new DataManager();
        return INSTANCE;
    }
}
