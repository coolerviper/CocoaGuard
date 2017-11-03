package com.cocoaguard.cocoaguard.Model;

/**
 * Created by mamma on 10/24/2016.
 */

public class ModelData
{


    private String longName;
    private String shortName;
    private int iconID;

    public ModelData(String longName, String shortName, int iconID)
    {
        this.longName = longName;
        this.shortName = shortName;
        this.iconID = iconID;
    }


    public String getLongName()
    {
        return longName;
    }

    public void setLongName(String longName)
    {
        this.longName = longName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public int getIconID()
    {
        return iconID;
    }

    public void setIconID(int iconID)
    {
        this.iconID = iconID;
    }


}
