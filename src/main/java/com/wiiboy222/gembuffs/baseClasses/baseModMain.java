package com.wiiboy222.gembuffs.baseClasses;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.wiiboy222.gembuffs.gemBuffs.items.*;
import com.wiiboy222.gembuffs.lib.*;

@Mod(modid=libReferences.MODID, name="Gem Buffs", version=libReferences.VERSION)

public class baseModMain {
	//items
	public static Item gem;
	public static Item healthGem;
	public static Item powerGem;
	public static Item defenceGem;
	public static Item waterGem;
	public static Item sightGem;
	public static Item invisibilityGem;
	public static Item movementGem;
	

	public static CreativeTabs GemBuffs = new CreativeTabs("Gem Buffs"){
		public Item getTabIconItem() {
			return gem;
		}
	};
	
	@SidedProxy(clientSide = libReferences.CLIENT, serverSide = libReferences.COMMON)
	public static proxyCommon proxy;
	
	@Mod.Instance(libReferences.MODID)
    private static baseModMain instance = new baseModMain();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	//Gems
		gem = new Item().setUnlocalizedName("Gem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem");
		GameRegistry.registerItem(gem, "Gem");
		healthGem = new healthGem().setUnlocalizedName("HealthGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_health").setMaxStackSize(1);
		GameRegistry.registerItem(healthGem, "Health Gem");
		defenceGem = new defenceGem().setUnlocalizedName("DefenceGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_defence").setMaxStackSize(1);
		GameRegistry.registerItem(defenceGem, "DefenceGem");
		movementGem = new movementGem().setUnlocalizedName("MovementGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_movement").setMaxStackSize(1);
		GameRegistry.registerItem(movementGem, "MovementGem");
		sightGem = new sightGem().setUnlocalizedName("SightGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_sight").setMaxStackSize(1);
		GameRegistry.registerItem(sightGem, "Sight Gem");
		powerGem = new powerGem().setUnlocalizedName("PowerGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_power").setMaxStackSize(1);
		GameRegistry.registerItem(powerGem, "Power Gem");
		waterGem = new waterGem().setUnlocalizedName("WaterGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_water").setMaxStackSize(1);
		GameRegistry.registerItem(waterGem, "Water Gem");
		invisibilityGem = new invisibilityGem().setUnlocalizedName("InvisibilityGem").setCreativeTab(GemBuffs).setTextureName("gembuffs:gem_invisibility").setMaxStackSize(1);
		GameRegistry.registerItem(invisibilityGem, "Invisibility Gem");

        
        //misc
        GameRegistry.registerWorldGenerator(new worldGen(), 1);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.registerRenderInformation();
		//recipes
		//GameRegistry.addRecipe(new ItemStack(healthGem), new Object[] {" 1 ", "3G4", " 2 ", 'G', gem, '1', Items.golden_apple, '2', Items.golden_apple, '3', Potion.heal, '4', Potion.regeneration});
	}	        
	public static baseModMain getInstance() {
		 return instance;
	}
}
