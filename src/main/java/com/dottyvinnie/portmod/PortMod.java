package com.dottyvinnie.portmod;


import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.init.ModBlocks;
import com.dottyvinnie.portmod.init.ModItems;
import com.dottyvinnie.portmod.init.RecipesPM;
import com.dottyvinnie.portmod.lib.Reference;
import com.dottyvinnie.portmod.proxies.CommonProxy;
import com.dottyvinnie.portmod.util.LogHelper;
import com.dottyvinnie.portmod.world.gen.WorldGeneratorPM;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)


public class PortMod 
	{
	
	@Mod.Instance(Reference.MOD_ID)
		public static PortMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
		public static CommonProxy proxy;

        public static CreativeTabs creativeTabPM = new CreativeTabs(Reference.MOD_ID)
        {
            @Override
            public Item getTabIconItem()
            {
                return ConfigurationHandler.enableCoarseDirt ? Item.getItemFromBlock(ModBlocks.coarse_dirt) : Item.getItemFromBlock(Blocks.anvil);
            }
        };


	@Mod.EventHandler
		public static void PreInit(FMLPreInitializationEvent event)
		{
            // Initiating Configuration
            ConfigurationHandler.init(event.getSuggestedConfigurationFile());
            FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		    ModItems.init();
			ModBlocks.init();
            GameRegistry.registerWorldGenerator(new WorldGeneratorPM(), 0);
            proxy.preInit();

			LogHelper.info("Pretialization Complete!");
		}
	
	@Mod.EventHandler
		public static void Init(FMLInitializationEvent event)
		{
			RecipesPM.init();
			proxy.init();

			LogHelper.info("Initialization Complete!");
		}
	
	@Mod.EventHandler
		public static void PostInit(FMLPostInitializationEvent event)
		{
			proxy.postInit();

			LogHelper.info("Post Initialization Complete!");
		}
	
	}
