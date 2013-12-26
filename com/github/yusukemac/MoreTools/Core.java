package com.github.yusukemac.MoreTools;

import java.net.Proxy;
import java.util.logging.Level;

import com.github.yusukemac.MoreTools.item.ItemHammer;
import com.github.yusukemac.MoreTools.item.ItemBase;
import com.github.yusukemac.MoreTools.item.ItemSnowplow;
import com.github.yusukemac.MoreTools.item.ItemStoneBreaker;
import com.github.yusukemac.MoreTools.item.ItemSuperDigger;
import com.github.yusukemac.MoreTools.item.ItemToolOfNature;
import com.github.yusukemac.MoreTools.item.ItemToolOfTheEarth;
import com.github.yusukemac.MoreTools.material.ToolMaterials;
import com.github.yusukemac.MoreTools.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = "YMMoretools",
		name = "yusukemac's More tools",
		version = "5_srg/1.6.4")
@NetworkMod(clientSideRequired = true)
public class Core {
	
	@Instance("YMMoretools")
	public static Core instance;
	@SidedProxy(clientSide = "com.github.yusukemac.MoreTools.proxy.ClientProxy", serverSide = "com.github.yusukemac.MoreTools.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static Achievement timeToSnowRemoval, timeToDismantling, getPlasticIngot, craftToolOfTheEarth;
	public static int AchievementID = 6300;
	
	public static final String ACHIEVEMENT_PAGE_NAME = "Yusukemac's MoreTools";
	
	public static int[] IDs;
	public static Property hiddennameProp, hammerProp, snowplowProp, superdiggerProp, toolofnatureProp, tooloftheearthProp, stonebreakerProp, plasticProp, tooloftheearthdebrisProp;
	
	public static Item hammerWood, hammerStone, hammerIron, hammerGold, hammerDiamond, hammerPlastic,
						snowplowWood, snowplowStone, snowplowIron, snowplowGold, snowplowDiamond, snowplowPlastic,
						superDigger, toolOfNature, toolOfTheEarth, StoneBreaker, toolOfTheEarthDebris;
	public static Item ingotPlastic;
	
	public static String[] names = new String[] {"§6超すごい整地用ツール§r", "§a自然系のツール§r", "§0✝漆黒のダイヤ大量消費ツール✝§r", "§d石専用ツール§r"};
	
	public static int HammerIDs[];
	public static int SnowplowIDs[];
	public static int SuperDiggerID, ToolOfNatureID, ToolOfTheEarthID, PlasticID, StoneBreakerID, ToolOfTheEarthDebrisID;
	public static EnumToolMaterial PLASTIC;
	public static Block orePlastic;
	
	public static final CreativeTabs tabYMTools = new CreativeTabYMTools("yusukemac's Tools");
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
		
		Register.registerItem(snowplowWood, "Wood Snowplow", "木の除雪機");
		Register.registerItem(snowplowStone, "Stone Snowplow", "石の除雪機");
		Register.registerItem(snowplowIron, "Iron Snowplow", "鉄の除雪機");
		Register.registerItem(snowplowGold, "Gold Snowplow", "金の除雪機");
		Register.registerItem(snowplowDiamond, "Diamond Snowplow", "ダイヤモンドの除雪機");
		Register.registerItem(snowplowPlastic, "Plastic Snowplow", "プラスチックの除雪機");
		
		Register.registerItem(hammerWood, "Wood Hammer", "木のハンマー");
		Register.registerItem(hammerStone, "Stone Hammer", "石のハンマー");
		Register.registerItem(hammerIron, "Iron Hammer", "鉄のハンマー");
		Register.registerItem(hammerGold, "Gold Hammer", "金のハンマー");
		Register.registerItem(hammerDiamond, "Diamond Hammer", "ダイヤモンドのハンマー");
		Register.registerItem(hammerPlastic, "Plastic Hammer", "プラスチックのハンマー");
		
		if (hiddennameProp.getBoolean(false))
		{
			Register.registerItem(superDigger, "§6Super Digger", names[0]);
			Register.registerItem(toolOfNature, "§aTool of Nature", names[1]);
			Register.registerItem(toolOfTheEarth, "§bTool of The Earth", names[2]);
			Register.registerItem(StoneBreaker, "§dSuper Breaker§r", names[3]);
		}
		else {
			Register.registerItem(superDigger, "§6Super Digger§r", "§6スーパーディガー§r");
			Register.registerItem(toolOfNature, "§aTool of Nature", "§a自然のツール§r");
			Register.registerItem(toolOfTheEarth, "§bTool of The Earth§r", "§b地球のツール§r");
			Register.registerItem(StoneBreaker, "Stone Breaker", "§dストーン破壊機§r");
		}
		
		Register.registerItem(ingotPlastic, "Plastic ingot", "プラスチックのインゴット");
		Register.registerItem(toolOfTheEarthDebris, "Tool of The Earth's Debris", "地球のツールの破片");
		
		Register.registerBlock(orePlastic, "Plastic ore", "プラスチック(の原料)鉱石");
		
		GameRegistry.registerWorldGenerator(new OreGenerator());
		
		registerRecipes();
		
	}
	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		ToolMaterials.setToolMaterial();
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		
		try {
			cfg.load();
			hiddennameProp = cfg.get("Mode", "hidden name", false);
			hammerProp = cfg.getItem("Hammers", 5300);
			snowplowProp = cfg.getItem("Snowplow", 5306);
			superdiggerProp = cfg.getItem("SuperDigger", 5313);
			toolofnatureProp = cfg.getItem("Tool of Nature", 5314);
			tooloftheearthProp = cfg.getItem("Tool of The Earth", 5315);
			plasticProp = cfg.getItem("Plastic ingot", 5316);
			stonebreakerProp = cfg.getItem("Stone Breaker", 5317);
			tooloftheearthdebrisProp = cfg.getItem("Tool of the Earth's Debris", 5318);
			
			hiddennameProp.comment = "^q^";
			hammerProp.comment = "if set to 5300, using 5300 ~ 5305 ids";	
			snowplowProp.comment = "if set to 5306, using 5306 ~ 5312 ids";
			superdiggerProp.comment = "use one ItemID. default:5313";
			toolofnatureProp.comment = "use one ItemID. default:5314";
			tooloftheearthProp.comment = "use one ItemID. default:5315";
			stonebreakerProp.comment = "use one ItemID. default:5317";
			
			tooloftheearthdebrisProp.comment = "use one ItemID. default:5318";
			
			
			plasticProp.comment = "use one ItemID. default:5316";
			
			HammerIDs = new int[] {hammerProp.getInt()-256, hammerProp.getInt()-255, hammerProp.getInt()-254, hammerProp.getInt()-253, hammerProp.getInt()-252, hammerProp.getInt()-251};
			SnowplowIDs = new int[] {snowplowProp.getInt()-256, snowplowProp.getInt()-255, snowplowProp.getInt()-254, snowplowProp.getInt()-253, snowplowProp.getInt()-252, snowplowProp.getInt()-251};
			SuperDiggerID = superdiggerProp.getInt()-256;
			ToolOfNatureID = toolofnatureProp.getInt()-256;
			ToolOfTheEarthID = tooloftheearthProp.getInt()-256;
			PlasticID = plasticProp.getInt()-256;
			StoneBreakerID = stonebreakerProp.getInt()-256;
			ToolOfTheEarthDebrisID = tooloftheearthdebrisProp.getInt()-256;
			
			IDs = new int[] {HammerIDs[0], HammerIDs[1], HammerIDs[2], HammerIDs[3], HammerIDs[4], HammerIDs[5], SnowplowIDs[0], SnowplowIDs[1], SnowplowIDs[2], SnowplowIDs[3], SnowplowIDs[4], SnowplowIDs[5], SuperDiggerID, ToolOfNatureID, ToolOfTheEarthID, PlasticID, StoneBreakerID, ToolOfTheEarthDebrisID};
		}
		
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "==================================================");
			FMLLog.log(Level.SEVERE, e, "Can't loaded SmartTools");
			FMLLog.log(Level.SEVERE, e, "Please remove Config file.");
			FMLLog.log(Level.SEVERE, e, "this is Config file Exception.");
			FMLLog.log(Level.SEVERE, e, "==================================================");
		}
		finally {
			cfg.save();
		}
		ingotPlastic = new ItemBase(PlasticID).setCreativeTab(tabYMTools).setUnlocalizedName("Plastic ingot").setTextureName("plastic_ingot");
		toolOfTheEarthDebris = new ItemBase(ToolOfTheEarthDebrisID).setCreativeTab(tabYMTools).setUnlocalizedName("Tool of The Earth's Debris").setTextureName("debris_tooloftheearth");
		
		hammerWood = new ItemHammer(HammerIDs[0], EnumToolMaterial.WOOD).setUnlocalizedName("Wood Hammer").setTextureName("wood_hammer");
		hammerStone = new ItemHammer(HammerIDs[1], EnumToolMaterial.STONE).setUnlocalizedName("Stone Hammer").setTextureName("stone_hammer");
		hammerIron = new ItemHammer(HammerIDs[2], EnumToolMaterial.IRON).setUnlocalizedName("Iron Hammer").setTextureName("iron_hammer");
		hammerGold = new ItemHammer(HammerIDs[3], EnumToolMaterial.GOLD).setUnlocalizedName("Gold Hammer").setTextureName("gold_hammer");
		hammerDiamond = new ItemHammer(HammerIDs[4], EnumToolMaterial.EMERALD).setUnlocalizedName("Diamond Hammer").setTextureName("diamond_hammer");
		hammerPlastic = new ItemHammer(HammerIDs[5], ToolMaterials.PLASTIC).setUnlocalizedName("Plastic Hammer").setTextureName("plastic_hammer");
		
		snowplowWood = new ItemSnowplow(SnowplowIDs[0], ToolMaterials.WOOD_snowplow).setUnlocalizedName("Wood Snowplow").setTextureName("wood_snowplow");
		snowplowStone = new ItemSnowplow(SnowplowIDs[1], ToolMaterials.STONE_snowplow).setUnlocalizedName("Stone Snowplow").setTextureName("stone_snowplow");
		snowplowIron = new ItemSnowplow(SnowplowIDs[2], ToolMaterials.IRON_snowplow).setUnlocalizedName("Iron Snowplow").setTextureName("iron_snowplow");
		snowplowGold = new ItemSnowplow(SnowplowIDs[3], ToolMaterials.GOLD_snowplow).setUnlocalizedName("Gold Snowplow").setTextureName("gold_snowplow");
		snowplowDiamond = new ItemSnowplow(SnowplowIDs[4], ToolMaterials.DIAMOND_snowplow).setUnlocalizedName("Diamond Snowplow").setTextureName("diamond_snowplow");
		snowplowPlastic = new ItemSnowplow(SnowplowIDs[5], ToolMaterials.PLASTIC).setUnlocalizedName("Plastic Snowplow").setTextureName("plastic_snowplow");
		
		superDigger = new ItemSuperDigger(SuperDiggerID, ToolMaterials.SUPERDIGGER).setUnlocalizedName("Super Digger").setTextureName("superdigger");
		toolOfNature = new ItemToolOfNature(ToolOfNatureID, ToolMaterials.TOOLOFNATURE).setUnlocalizedName("Tool of Nature").setTextureName("toolofnature");
		toolOfTheEarth = new ItemToolOfTheEarth(ToolOfTheEarthID, ToolMaterials.TOOLOFTHEEARTH).setUnlocalizedName("Tool of The Earth").setTextureName("tooloftheearth");
		
		StoneBreaker = new ItemStoneBreaker(StoneBreakerID, ToolMaterials.STONEBREAKER).setUnlocalizedName("Stone Breaker").setTextureName("stonebreaker");
		
		orePlastic = new OrePlastic(1000, Material.rock).setHardness(4.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("testOre").setCreativeTab(tabYMTools).setTextureName("plastic_ore");
		OreDictionary.registerOre("orePlastic", orePlastic);
		OreDictionary.registerOre("ingotPlastic", ingotPlastic);
		
		
		timeToSnowRemoval = new Achievement(AchievementID, "timeToSnowRemoval", 0, 0, snowplowWood, (Achievement)null).setIndependent().registerAchievement();
		timeToDismantling = new Achievement(AchievementID+1, "timeToDismantling", 2, 1, hammerWood, timeToSnowRemoval).registerAchievement();
		getPlasticIngot = new Achievement(AchievementID+2, "getPlasticIngot",4, -1, ingotPlastic, timeToDismantling).registerAchievement();
		craftToolOfTheEarth = new Achievement(AchievementID+3, "millionaire", 4, 2, toolOfTheEarth, getPlasticIngot).setSpecial().registerAchievement();
		
		achievementsName();
		
		Achievement[] achievements = new Achievement[] { timeToSnowRemoval, timeToDismantling, getPlasticIngot, craftToolOfTheEarth };
		AchievementPage.registerAchievementPage(new AchievementPage(ACHIEVEMENT_PAGE_NAME, achievements));
		proxy.init();
		
	}
	
	public void achievementsName()
	{
		LanguageRegistry.instance().addStringLocalization(timeToSnowRemoval.statName, "en_US", "Time to Snow removal!");
		LanguageRegistry.instance().addStringLocalization(timeToSnowRemoval.statName, "ja_JP", "いざ除雪!");
		LanguageRegistry.instance().addStringLocalization(timeToSnowRemoval.statName + ".desc", "en_US", "craft any Snowplow");
		LanguageRegistry.instance().addStringLocalization(timeToSnowRemoval.statName + ".desc", "ja_JP", "除雪機を作る");
		
		LanguageRegistry.instance().addStringLocalization(timeToDismantling.statName, "en_US", "Time to Dismantling!");
		LanguageRegistry.instance().addStringLocalization(timeToDismantling.statName, "ja_JP", "いざ解体!");
		LanguageRegistry.instance().addStringLocalization(timeToDismantling.statName + ".desc", "en_US", "craft any Hammer");
		LanguageRegistry.instance().addStringLocalization(timeToDismantling.statName + ".desc", "ja_JP", "ハンマーを作る");
		
		LanguageRegistry.instance().addStringLocalization(getPlasticIngot.statName, "en_US", "Get plastic ingot!");
		LanguageRegistry.instance().addStringLocalization(getPlasticIngot.statName, "ja_JP", "プラスチックインゴットを手に入れる");
		LanguageRegistry.instance().addStringLocalization(getPlasticIngot.statName + ".desc", "en_US", "smelting Plastic ore, and get ingots");
		LanguageRegistry.instance().addStringLocalization(getPlasticIngot.statName + ".desc", "ja_JP", "プラスチック鉱石を精錬し、インゴットを取得しよう");
		
		LanguageRegistry.instance().addStringLocalization(craftToolOfTheEarth.statName, "en_US", "§eMILLIONAIRE§r");
		LanguageRegistry.instance().addStringLocalization(craftToolOfTheEarth.statName, "ja_JP", "§e大富豪§r");
		LanguageRegistry.instance().addStringLocalization(craftToolOfTheEarth.statName + ".desc", "en_US", "craft §bTool of The Earth§r.");
		LanguageRegistry.instance().addStringLocalization(craftToolOfTheEarth.statName + ".desc", "ja_JP", "§b地球のツール§rを作る");
	}
	
	public void registerRecipes()
	{
		ToolHelper.addRecipe(hammerWood, 1, ToolHelper.createHammerObject(Block.planks, Item.stick));
		ToolHelper.addRecipe(hammerStone, 1, ToolHelper.createHammerObject(Block.cobblestone, Item.stick));
		ToolHelper.addRecipe(hammerIron, 1, ToolHelper.createHammerObject(Item.ingotIron, Item.stick));
		ToolHelper.addRecipe(hammerGold, 1, ToolHelper.createHammerObject(Item.ingotGold, Item.stick));
		ToolHelper.addRecipe(hammerDiamond, 1, ToolHelper.createHammerObject(Item.diamond, Item.stick));
		
		ToolHelper.addRecipe(snowplowWood, 1, ToolHelper.createSnowplowObject(Block.planks, Item.stick));
		ToolHelper.addRecipe(snowplowStone, 1, ToolHelper.createSnowplowObject(Block.cobblestone, Item.stick));
		ToolHelper.addRecipe(snowplowIron, 1, ToolHelper.createSnowplowObject(Item.ingotIron, Item.stick));
		ToolHelper.addRecipe(snowplowGold, 1, ToolHelper.createSnowplowObject(Item.ingotGold, Item.stick));
		ToolHelper.addRecipe(snowplowDiamond, 1, ToolHelper.createSnowplowObject(Item.diamond, Item.stick));
		ToolHelper.addRecipe(snowplowPlastic, 1, ToolHelper.createSnowplowObject(ingotPlastic, Item.stick));
		
		ToolHelper.addRecipe(superDigger, 1, new Object[] {"SMP", " D ", " D ", 'S', snowplowDiamond, 'M', hammerDiamond, 'P', Item.pickaxeDiamond, 'D', Item.diamond});
		ToolHelper.addRecipe(toolOfNature, 1, new Object[]{"ABC", " X ", " X ", 'A', Item.shears, 'B', Item.swordDiamond, 'C', Item.hoeDiamond, 'X', Item.diamond});
		ToolHelper.addRecipe(toolOfTheEarth, 1, new Object[] {"SDT", "GXG", "RXR", 'S', superDigger, 'D', Block.blockDiamond, 'T', toolOfNature, 'G', Block.glowStone, 'R', Block.blockRedstone, 'X', Item.diamond});
		
		ToolHelper.addRecipe(StoneBreaker, 1, new Object[] {"XPX", " S ", " S ", 'X', Item.diamond, 'P', Item.pickaxeDiamond, 'S', Item.stick});
		
		ItemStack is = new ItemStack(Item.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(toolOfTheEarth), new Object[] { new ItemStack(toolOfTheEarthDebris), is, is, is, is, is });
		
		GameRegistry.addSmelting(orePlastic.blockID, new ItemStack(ingotPlastic), 3.0F);
	}
}
