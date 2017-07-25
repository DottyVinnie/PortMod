package com.dottyvinnie.portmod.items;


import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.item.Item;

public class ItemPrismarineCrystals extends Item implements IConfig
{
	public ItemPrismarineCrystals()
	{
		super();
		this.setTextureName(Utility.getItemTexture("prismarine_crystals"));
		this.setUnlocalizedName(Utility.getUnlocalisedName("prismarine_crystals"));
		this.setCreativeTab(ConfigurationHandler.enablePrismarine ? PortMod.creativeTabPM : null);
	}

	@Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.enablePrismarine;
    }
}
