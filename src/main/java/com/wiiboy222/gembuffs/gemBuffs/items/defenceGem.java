package com.wiiboy222.gembuffs.gemBuffs.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class defenceGem extends Item {

	public static Item defenceGem; {
        }
        public boolean hasEffect(ItemStack itemstack)
        {
                return true;
        }
        public EnumRarity getRarity(ItemStack itemstack)
        {
                return EnumRarity.epic;
        }
        public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
        {
            par3List.add("�9The Defending Gemstone");
            par3List.add("�fRight Click For :");
            par3List.add("�fResistance Buffs");
        }
        public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
        {
     	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 600, 2));
     	entityplayer.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 600, 2));
     	
    	return itemstack;
        }
}
