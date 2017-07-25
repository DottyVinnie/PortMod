package com.dottyvinnie.portmod.util;

import com.dottyvinnie.portmod.lib.Reference;

/**
 * Created by Dotty on 15-Mar-17.
 */
public class Utility
{
    public static String getUnlocalisedName(String name)
    {
        return Reference.MOD_ID + "." + name;
    }

    public static String getBlockTexture(String name)
    {
        return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
    }

    public static String getItemTexture(String name)
    {
        return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
    }
}
