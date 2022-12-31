
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createstructures.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.createstructures.item.GasmaskItem;
import net.mcreator.createstructures.CreateStructuresMod;

public class CreateStructuresModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CreateStructuresMod.MODID);
	public static final RegistryObject<Item> GASMASK_HELMET = REGISTRY.register("gasmask_helmet", () -> new GasmaskItem.Helmet());
}
