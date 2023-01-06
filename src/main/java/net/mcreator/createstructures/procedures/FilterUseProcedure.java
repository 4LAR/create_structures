package net.mcreator.createstructures.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.createstructures.network.CreateStructuresModVariables;
import net.mcreator.createstructures.init.CreateStructuresModItems;

public class FilterUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.getItem() == CreateStructuresModItems.GASMASK_HELMET.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.getItem() == CreateStructuresModItems.GASMASKIMPROVED_HELMET.get()) {
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))
					.setDamageValue((int) ((itemstack).getDamageValue() - CreateStructuresModVariables.MapVariables.get(world).REPAIR_GASMASK));
			(itemstack).shrink(1);
		}
	}
}
