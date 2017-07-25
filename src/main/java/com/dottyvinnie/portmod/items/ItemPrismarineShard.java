package com.dottyvinnie.portmod.items;


import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.item.Item;

public class ItemPrismarineShard extends Item implements IConfig
{
	public ItemPrismarineShard()
	{
		super();
		this.setTextureName(Utility.getItemTexture("prismarine_shard"));
		this.setUnlocalizedName(Utility.getUnlocalisedName("prismarine_shard"));
		this.setCreativeTab(ConfigurationHandler.enablePrismarine ? PortMod.creativeTabPM : null);
	}

	@Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.enablePrismarine;
    }
}
