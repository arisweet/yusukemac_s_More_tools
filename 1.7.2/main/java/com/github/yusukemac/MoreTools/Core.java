package com.github.yusukemac.MoreTools;

import com.github.yusukemac.MoreTools.block.blockPlasticOre;
import com.github.yusukemac.MoreTools.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import com.github.yusukemac.MoreTools.item.ItemHammer;
import com.github.yusukemac.MoreTools.item.ItemSnowplow;
import com.github.yusukemac.MoreTools.item.ItemStoneBreaker;
import com.github.yusukemac.MoreTools.item.ItemSuperDigger;
import com.github.yusukemac.MoreTools.item.ItemToolOfNature;
import com.github.yusukemac.MoreTools.item.ItemToolOfTheEarth;
import com.github.yusukemac.MoreTools.material.ToolMaterials;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
        modid = "YMMoretools",
        name = "Yusukemac's More tools",
        version = "2.0")

/**
 * 一番重要なクラス。
 *
 * @author yusukemac
 */
public class Core {

    @Mod.Instance("YMMoretools")
    public static Core instance;

    @SidedProxy(clientSide = "com.github.yusukemac.MoreTools.proxy.ClientProxy", serverSide = "com.github.yusukemac.MoreTools.proxy.CommonProxy")
    public static CommonProxy proxy;

    //Achievements
    public static Achievement timeToSnowRemoval, timeToDismantling, getPlasticIngot, craftToolOfTheEarth;

    //Achievement page name
    public static final String ACHIEVEMENT_PAGE_NAME = "Yusukemac's MoreTools";

    //Tools
    public static Item hammerWood, hammerStone, hammerIron, hammerGold, hammerDiamond, hammerPlastic,
            snowplowWood, snowplowStone, snowplowIron, snowplowGold, snowplowDiamond, snowplowPlastic,
            superDigger, toolOfNature, toolOfTheEarth, StoneBreaker, toolOfTheEarthDebris;
    //ingot
    public static Item ingotPlastic;

    //ふざけてる名前
    //public static String[] names = new String[]{"§6超すごい整地用ツール§r", "§a自然系のツール§r", "§0✝漆黒のダイヤ大量消費ツール✝§r", "§d石専用ツール§r"};

    /**
     * 新しいツール用マテリアル
     */
    public ToolMaterial PLASTIC;
    /**
     * プラスチック鉱石
     */
    public static Block orePlastic;

    /**
     * 追加ツールのためのクリエイティブタブ *
     */
    public static final CreativeTabs tabYMTools = new CreativeTabYMTools("YMTools");

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        ToolMaterials.setToolMaterial();
        /*Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try {
            cfg.load();
            //hiddennameProp = cfg.get("mode", "hidden name", false);
            hammerProp = cfg.get("item", "Hammers", 5300);
            snowplowProp = cfg.get("item", "Snowplow", 5306);
            superdiggerProp = cfg.get("item", "SuperDigger", 5313);
            toolofnatureProp = cfg.get("item", "Tool of Nature", 5314);
            tooloftheearthProp = cfg.get("item", "Tool of The Earth", 5315);
            plasticProp = cfg.get("item", "Plastic ingot", 5316);
            stonebreakerProp = cfg.get("item", "Stone Breaker", 5317);
            tooloftheearthdebrisProp = cfg.get("item", "Tool of the Earth's Debris", 5318);

            hiddennameProp.comment = "^q^";
            hammerProp.comment = "if set to 5300, using 5300 ~ 5305 ids";
            snowplowProp.comment = "if set to 5306, using 5306 ~ 5312 ids";
            superdiggerProp.comment = "use one ItemID. default:5313";
            toolofnatureProp.comment = "use one ItemID. default:5314";
            tooloftheearthProp.comment = "use one ItemID. default:5315";
            stonebreakerProp.comment = "use one ItemID. default:5317";
            tooloftheearthdebrisProp.comment = "use one ItemID. default:5318";
            plasticProp.comment = "use one ItemID. default:5316";

            HammerIDs = new int[]{hammerProp.getInt() - 256, hammerProp.getInt() - 255, hammerProp.getInt() - 254, hammerProp.getInt() - 253, hammerProp.getInt() - 252, hammerProp.getInt() - 251};
            SnowplowIDs = new int[]{snowplowProp.getInt() - 256, snowplowProp.getInt() - 255, snowplowProp.getInt() - 254, snowplowProp.getInt() - 253, snowplowProp.getInt() - 252, snowplowProp.getInt() - 251};
            SuperDiggerID = superdiggerProp.getInt() - 256;
            ToolOfNatureID = toolofnatureProp.getInt() - 256;
            ToolOfTheEarthID = tooloftheearthProp.getInt() - 256;
            PlasticID = plasticProp.getInt() - 256;
            StoneBreakerID = stonebreakerProp.getInt() - 256;
            ToolOfTheEarthDebrisID = tooloftheearthdebrisProp.getInt() - 256;

            IDs = new int[]{HammerIDs[0], HammerIDs[1], HammerIDs[2], HammerIDs[3], HammerIDs[4], HammerIDs[5], SnowplowIDs[0], SnowplowIDs[1], SnowplowIDs[2], SnowplowIDs[3], SnowplowIDs[4], SnowplowIDs[5], SuperDiggerID, ToolOfNatureID, ToolOfTheEarthID, PlasticID, StoneBreakerID, ToolOfTheEarthDebrisID};

        } catch (Exception e) {
            FMLLog.log(org.apache.logging.log4j.Level.ERROR, e, null);
			/*FMLLog.log(Level.SEVERE, e, "==================================================");
			FMLLog.log(Level.SEVERE, e, "Can't loaded Yusukemac\'s MoreTools");
			FMLLog.log(Level.SEVERE, e, "Please remove Config file.");
			FMLLog.log(Level.SEVERE, e, "this is Config file Exception.");
			FMLLog.log(Level.SEVERE, e, "==================================================");

        } finally {
            cfg.save();
        }
        */

        ingotPlastic = new Item().setCreativeTab(tabYMTools).setUnlocalizedName("ingotPlastic").setTextureName("ymmoretools:plastic_ingot");
        toolOfTheEarthDebris = new Item().setCreativeTab(tabYMTools).setUnlocalizedName("toolOfTheEarthDebris").setTextureName("debris_tooloftheearth");

        hammerWood = new ItemHammer(ToolMaterial.WOOD).setUnlocalizedName("hammerWood").setTextureName("ymmoretools:wood_hammer);
        hammerStone = new ItemHammer(ToolMaterial.STONE).setUnlocalizedName("hammerStone").setTextureName("ymmoretools:stone_hammer");
        hammerIron = new ItemHammer(ToolMaterial.IRON).setUnlocalizedName("hammerIron").setTextureName("ymmoretools:iron_hammer");
        hammerGold = new ItemHammer(ToolMaterial.GOLD).setUnlocalizedName("hammerGold").setTextureName("ymmoretools:gold_hammer");
        hammerDiamond = new ItemHammer(ToolMaterial.EMERALD).setUnlocalizedName("hammerDiamond").setTextureName("ymmoretools:diamond_hammer");
        hammerPlastic = new ItemHammer(ToolMaterials.PLASTIC).setUnlocalizedName("hammerPlastic").setTextureName("ymmoretools:plastic_hammer");

        snowplowWood = new ItemSnowplow(ToolMaterials.WOOD_snowplow).setUnlocalizedName("snowplowWood").setTextureName("ymmoretools:wood_snowplow");
        snowplowStone = new ItemSnowplow(ToolMaterials.STONE_snowplow).setUnlocalizedName("snowplowStone").setTextureName("ymmoretools:stone_snowplow");
        snowplowIron = new ItemSnowplow(ToolMaterials.IRON_snowplow).setUnlocalizedName("snowplowIron").setTextureName("ymmoretools:iron_snowplow");
        snowplowGold = new ItemSnowplow(ToolMaterials.GOLD_snowplow).setUnlocalizedName("snowplowGold").setTextureName("ymmoretools:gold_snowplow");
        snowplowDiamond = new ItemSnowplow(ToolMaterials.DIAMOND_snowplow).setUnlocalizedName("snowplowDiamond").setTextureName("ymmoretools:diamond_snowplow");
        snowplowPlastic = new ItemSnowplow(ToolMaterials.PLASTIC).setUnlocalizedName("snowplowPlastic").setTextureName("ymmoretools:plastic_snowplow");

        superDigger = new ItemSuperDigger(ToolMaterials.SUPERDIGGER).setUnlocalizedName("superDigger").setTextureName("ymmoretools:superdigger");
        toolOfNature = new ItemToolOfNature(ToolMaterials.TOOLOFNATURE).setUnlocalizedName("toolOfNature").setTextureName("ymmoretools:toolofnature");
        toolOfTheEarth = new ItemToolOfTheEarth(ToolMaterials.TOOLOFTHEEARTH).setUnlocalizedName("toolOfTheEarth").setTextureName("ymmoretools:tooloftheearth");

        StoneBreaker = new ItemStoneBreaker(ToolMaterials.STONEBREAKER).setUnlocalizedName("stoneBreaker").setTextureName("ymmoretools:stonebreaker");

        //ブロックの設定。機能はないので普通にBlockクラスで...といきたいがBlockクラスのコンストラクタがprotectedなので継承したクラスを用います
        orePlastic = new blockPlasticOre(Material.rock);
        OreDictionary.registerOre("orePlastic", orePlastic);
        OreDictionary.registerOre("ingotPlastic", ingotPlastic);

        // 実績の設定。
        timeToSnowRemoval = new Achievement("YM_1", "timeToSnowRemoval", 0, 0, snowplowWood, (Achievement) null).initIndependentStat().registerStat();
        timeToDismantling = new Achievement("YM_2", "timeToDismantling", 2, 1, hammerWood, timeToSnowRemoval).registerStat();
        getPlasticIngot = new Achievement("YM_3", "getPlasticIngot", 4, -1, ingotPlastic, timeToDismantling).registerStat();
        craftToolOfTheEarth = new Achievement("YM_4", "millionaire", 4, 2, toolOfTheEarth, getPlasticIngot).setSpecial().registerStat();

        Achievement[] achievements = new Achievement[]{timeToSnowRemoval, timeToDismantling, getPlasticIngot, craftToolOfTheEarth};
        AchievementPage.registerAchievementPage(new AchievementPage(ACHIEVEMENT_PAGE_NAME, achievements));

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {

        GameRegistry.registerItem(snowplowWood, "Wood snowplow", "木の除雪機");
        GameRegistry.registerItem(snowplowStone, "Stone snowplow", "石の除雪機");
        GameRegistry.registerItem(snowplowIron, "Iron snowplow", "鉄の除雪機");
        GameRegistry.registerItem(snowplowGold, "Gold snowplow", "金の除雪機");
        GameRegistry.registerItem(snowplowDiamond, "Diamond snowplow", "ダイヤモンドの除雪機");
        GameRegistry.registerItem(snowplowPlastic, "Plastic snowplow", "プラスチックの除雪機");

        GameRegistry.registerItem(hammerWood, "Wood hammer");
        GameRegistry.registerItem(hammerStone, "Stone hammer");
        GameRegistry.registerItem(hammerIron, "Iron hammer");
        GameRegistry.registerItem(hammerGold, "Gold hammer");
        GameRegistry.registerItem(hammerDiamond, "Diamond hammer");
        GameRegistry.registerItem(hammerPlastic, "Plastic hammer");

        //おふざけ名前適用 - 1.7.2対応時にコメントアウト
        /*if (hiddennameProp.getBoolean(false)) {
            GameRegistry.registerItem(superDigger, "§superDigger", names[0]);
            GameRegistry.registerItem(toolOfNature, "§aTool of Nature", names[1]);
            GameRegistry.registerItem(toolOfTheEarth, "§bTool of The Earth", names[2]);
            GameRegistry.registerItem(StoneBreaker, "§dSuper Breaker§r", names[3]);
        }
        */

        //ふつうの名前
        //else {
            GameRegistry.registerItem(superDigger, "§6Super Digger§r");
            GameRegistry.registerItem(toolOfNature, "§aTool of Nature§r");
            GameRegistry.registerItem(toolOfTheEarth, "§bTool of The Earth§r");
            GameRegistry.registerItem(StoneBreaker, "§dStone Breaker§r");
        //}

        GameRegistry.registerItem(ingotPlastic, "Plastic ingot");
        GameRegistry.registerItem(toolOfTheEarthDebris, "Tool of The Earth's Debris");

        GameRegistry.registerBlock(orePlastic, "Plastic ore");

        GameRegistry.registerWorldGenerator(new OreGenerator(), 64);

        registerRecipes();

        proxy.init();
    }

    /**
     * @author yusukemac
     * 一連のレシピを登録。
     */
    private void registerRecipes() {
        ToolHelper.addRecipe(hammerWood, 1, ToolHelper.createHammerObject(Blocks.planks, Items.stick));
        ToolHelper.addRecipe(hammerStone, 1, ToolHelper.createHammerObject(Blocks.cobblestone, Items.stick));
        ToolHelper.addRecipe(hammerIron, 1, ToolHelper.createHammerObject(Items.iron_ingot, Items.stick));
        ToolHelper.addRecipe(hammerGold, 1, ToolHelper.createHammerObject(Items.gold_ingot, Items.stick));
        ToolHelper.addRecipe(hammerDiamond, 1, ToolHelper.createHammerObject(Items.diamond, Items.stick));

        ToolHelper.addRecipe(snowplowWood, 1, ToolHelper.createSnowplowObject(Blocks.planks, Items.stick));
        ToolHelper.addRecipe(snowplowStone, 1, ToolHelper.createSnowplowObject(Blocks.cobblestone, Items.stick));
        ToolHelper.addRecipe(snowplowIron, 1, ToolHelper.createSnowplowObject(Items.iron_ingot, Items.stick));
        ToolHelper.addRecipe(snowplowGold, 1, ToolHelper.createSnowplowObject(Items.gold_ingot, Items.stick));
        ToolHelper.addRecipe(snowplowDiamond, 1, ToolHelper.createSnowplowObject(Items.diamond, Items.stick));
        ToolHelper.addRecipe(snowplowPlastic, 1, ToolHelper.createSnowplowObject(ingotPlastic, Items.stick));

        ToolHelper.addRecipe(superDigger, 1, new Object[]{"SMP", " D ", " D ", 'S', snowplowDiamond, 'M', hammerDiamond, 'P', Items.diamond_pickaxe, 'D', Items.diamond});
        ToolHelper.addRecipe(toolOfNature, 1, new Object[]{"ABC", " X ", " X ", 'A', Items.shears, 'B', Items.diamond_sword, 'C', Items.diamond_hoe, 'X', Items.diamond});
        ToolHelper.addRecipe(toolOfTheEarth, 1, new Object[]{"SDT", "GXG", "RXR", 'S', superDigger, 'D', Blocks.diamond_block, 'T', toolOfNature, 'G', Blocks.glowstone, 'R', Blocks.redstone_block, 'X', Items.diamond});

        ToolHelper.addRecipe(StoneBreaker, 1, new Object[]{"XPX", " S ", " S ", 'X', Items.diamond, 'P', Items.diamond_pickaxe, 'S', Items.stick});

        ItemStack is = new ItemStack(Items.diamond);
        GameRegistry.addShapelessRecipe(new ItemStack(toolOfTheEarth), new Object[]{new ItemStack(toolOfTheEarthDebris), is, is, is, is, is});

        GameRegistry.addSmelting(orePlastic, new ItemStack(ingotPlastic), 3.0F);
    }
}
