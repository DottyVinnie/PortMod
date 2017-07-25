package com.dottyvinnie.portmod.init;


import com.dottyvinnie.portmod.blocks.BlockNewStone;
import com.dottyvinnie.portmod.config.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipesPM
{
    public static void init()
    {
        registerOreDictionary();
        registerRecipes();
        removeRecipes();
    }

    private static void removeRecipes()
    {

    }

    private static void registerOreDictionary()
    {
        OreDictionary.registerOre("chestWood", new ItemStack(Blocks.chest));
        OreDictionary.registerOre("trapdoorWood", Blocks.trapdoor);

        if (ConfigurationHandler.enableNewStone)
        {
            OreDictionary.registerOre("stoneAndesite", new ItemStack(ModBlocks.stone, 1, BlockNewStone.ANDESITE));
            OreDictionary.registerOre("stoneDiorite", new ItemStack(ModBlocks.stone, 1, BlockNewStone.DIORITE));
            OreDictionary.registerOre("stoneGranite", new ItemStack(ModBlocks.stone, 1, BlockNewStone.GRANITE));
            OreDictionary.registerOre("stoneAndesitePolished", new ItemStack(ModBlocks.stone, 1, BlockNewStone.POLISHED_ANDESITE));
            OreDictionary.registerOre("stoneDioritePolished", new ItemStack(ModBlocks.stone, 1, BlockNewStone.POLISHED_DIORITE));
            OreDictionary.registerOre("stoneGranitePolished", new ItemStack(ModBlocks.stone, 1, BlockNewStone.POLISHED_GRANITE));
        }

        if (ConfigurationHandler.enablePrismarine)
        {
            OreDictionary.registerOre("shardPrismarine", new ItemStack(ModItems.prismarine_shard));
            OreDictionary.registerOre("crystalPrismarine", new ItemStack(ModItems.prismarine_crystals));
            OreDictionary.registerOre("blockPrismarine", new ItemStack(ModBlocks.prismarine, 1, OreDictionary.WILDCARD_VALUE));
        }
    }

	private static void registerRecipes()
	{
		//Recipies
        if (ConfigurationHandler.enableNewStone)
        {
            // Andesite
            addShapelessRecipe(new ItemStack(ModBlocks.stone, 2, BlockNewStone.ANDESITE), new ItemStack(Blocks.cobblestone), "stoneDiorite");
            addShapedRecipe(new ItemStack(ModBlocks.stone, 4, BlockNewStone.POLISHED_ANDESITE), "xx", "xx", 'x', "stoneAndesite");
            // Diorite
            addShapedRecipe(new ItemStack(ModBlocks.stone, 2, BlockNewStone.DIORITE), "xy", "yx", 'x', new ItemStack(Blocks.cobblestone), 'y', "gemQuartz");
            addShapedRecipe(new ItemStack(ModBlocks.stone, 4, BlockNewStone.POLISHED_DIORITE), "xx", "xx", 'x', "stoneDiorite");
            // Granite
            addShapelessRecipe(new ItemStack(ModBlocks.stone, 2, BlockNewStone.GRANITE), "gemQuartz", "stoneDiorite");
            addShapedRecipe(new ItemStack(ModBlocks.stone, 4, BlockNewStone.POLISHED_GRANITE), "xx", "xx", 'x', "stoneGranite");

        }

        if (ConfigurationHandler.enableIronNugget)
        {
            addShapelessRecipe(new ItemStack(ModItems.iron_nugget, 9), "ingotIron");
            addShapedRecipe(new ItemStack(Items.iron_ingot), "www", "www", "www", 'w', ModItems.iron_nugget);
        }

        if (ConfigurationHandler.enablePrismarine)
        {
            int PLAIN = 0;
            int BRICKS = 1;
            int DARK = 2;

            addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, DARK), "xxx", "xyx", "xxx", 'x', "shardPrismarine", 'y', "dyeBlack");
            addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, PLAIN), "xx", "xx", 'x', "shardPrismarine");
            addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, BRICKS), "xxx", "xxx", "xxx", 'x', "shardPrismarine");
            addShapedRecipe(new ItemStack(ModBlocks.sea_lantern), "xyx", "yyy", "xyx", 'x', "shardPrismarine", 'y', "crystalPrismarine");
        }

		//Smelting
        if (ConfigurationHandler.enableIronNugget)
        {
            GameRegistry.addSmelting(Items.iron_boots, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_leggings, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_chestplate, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_helmet, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_hoe, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_sword, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_shovel, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_axe, new ItemStack(ModItems.iron_nugget), 3.5F);
            GameRegistry.addSmelting(Items.iron_pickaxe, new ItemStack(ModItems.iron_nugget), 3.5F);
        }
	}

    private static void addShapedRecipe(ItemStack output, Object... objects)
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(output, objects));
    }

    private static void addShapelessRecipe(ItemStack output, Object... objects)
    {
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, objects));
    }
}
