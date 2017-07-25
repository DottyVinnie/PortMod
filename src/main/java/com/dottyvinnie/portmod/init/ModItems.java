package com.dottyvinnie.portmod.init;

import com.dottyvinnie.portmod.IConfig;
import com.dottyvinnie.portmod.items.ItemIronNugget;
import com.dottyvinnie.portmod.items.ItemPrismarineCrystals;
import com.dottyvinnie.portmod.items.ItemPrismarineShard;
import com.dottyvinnie.portmod.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.lang.reflect.Field;

@GameRegistry.ObjectHolder(Reference.MOD_ID)

public class ModItems
{
	public static final Item prismarine_crystals = new ItemPrismarineCrystals();
	public static final Item prismarine_shard = new ItemPrismarineShard();
	public static final Item iron_nugget = new ItemIronNugget();

    public static void init()
    {
        try {
            for (Field f : ModItems.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Item)
                    registerItem((Item) obj);
                else if (obj instanceof Item[])
                    for (Item item : (Item[]) obj)
                        registerItem(item);
            }
        }

        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void registerItem(Item item)
    {
        if (!(item instanceof IConfig) || ((IConfig) item).isEnabled())
        {
            String name = item.getUnlocalizedName();
            String[] strings = name.split("\\.");
            GameRegistry.registerItem(item, strings[strings.length - 1]);
        }
    }
}
