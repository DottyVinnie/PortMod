package com.dottyvinnie.portmod.config;

import com.dottyvinnie.portmod.lib.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;


/**
 * Created by Dotty on 15-Mar-17.
 */
public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean enableCoarseDirt = true;
    public static boolean enablePurpurBlock = true;
    public static boolean enableMagmaBlock = true;


    public static boolean enableIronNugget = true;


    //public static boolean noResourcePack = true;
    public static boolean enableBone = true;
    public static boolean enableNewStone = true;
    public static boolean enablePrismarine = true;
    public static int maxClusterSize = 32;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        //noResourcePack = configuration.getBoolean("noResourcePack", Configuration.CATEGORY_GENERAL, true, "Change to false to use resource pack textures.");
        enableCoarseDirt = configuration.getBoolean("enableCoarseDirt", Configuration.CATEGORY_GENERAL, true, "Change to false to disable Coarse Dirt.");
        enablePrismarine = configuration.getBoolean("enablePrismarine", Configuration.CATEGORY_GENERAL, true, "Change to false to disable Prismarine(Disables all things Prismarine).");
        enableIronNugget = configuration.getBoolean("enableIronNugget", Configuration.CATEGORY_GENERAL, true, "Change to false to disable the Iron Nugget.");
        enablePurpurBlock = configuration.getBoolean("enablePurpurBlock", Configuration.CATEGORY_GENERAL, true, "Change to false to disable Purpur Blocks.");
        enableMagmaBlock = configuration.getBoolean("enableMagmaBlock", Configuration.CATEGORY_GENERAL, true, "Change to false to disable MagmaBlock.");
        enableNewStone = configuration.getBoolean("enableNewStone", Configuration.CATEGORY_GENERAL, true, "Change to false to disable 1.8 Stones(Andesite, Diorite, Granite).");
        enableBone = configuration.getBoolean("enableBone", Configuration.CATEGORY_GENERAL, true, "Change to false to disable BoneBlock.");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
}
