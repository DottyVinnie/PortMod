package com.dottyvinnie.portmod.items;


import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.PortMod;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import com.dottyvinnie.portmod.util.Utility;
import net.minecraft.item.Item;

public class ItemIronNugget extends Item implements IConfig
{
	public ItemIronNugget()
	{
		super();
		this.setTextureName(Utility.getItemTexture("iron_nugget"));
		this.setUnlocalizedName(Utility.getUnlocalisedName("iron_nugget"));
		this.setCreativeTab(ConfigurationHandler.enableIronNugget ? PortMod.creativeTabPM : null);
	}

	@Override
	public boolean isEnabled()
	{
		return ConfigurationHandler.enableIronNugget;
	}
}
