
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createstructures.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.createstructures.CreateStructuresMod;

public class CreateStructuresModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CreateStructuresMod.MODID);
	public static final RegistryObject<Item> ZOMBIE = REGISTRY.register("zombie_spawn_egg",
			() -> new ForgeSpawnEggItem(CreateStructuresModEntities.ZOMBIE, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
