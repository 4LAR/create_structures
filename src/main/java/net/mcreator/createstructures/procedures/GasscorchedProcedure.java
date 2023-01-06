package net.mcreator.createstructures.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.createstructures.network.CreateStructuresModVariables;
import net.mcreator.createstructures.init.CreateStructuresModItems;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class GasscorchedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CreateStructuresModVariables.MapVariables.get(world).random_tick_potion_start < CreateStructuresModVariables.MapVariables
				.get(world).random_tick_potion) {
			if (new ResourceLocation("create_structures:scorched").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.getItem() == CreateStructuresModItems.RAG_HELMET.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.getItem() == CreateStructuresModItems.GASMASK_HELMET.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.getItem() == CreateStructuresModItems.GASMASKIMPROVED_HELMET.get()) {
					if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))
							.getDamageValue() < ((entity instanceof LivingEntity _entGetArmor
									? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD)
									: ItemStack.EMPTY)).getMaxDamage() - 1) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _entGetArmor
									? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD)
									: ItemStack.EMPTY);
							if (_ist.hurt(1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 50, 2));
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 50, 2));
				}
			}
			CreateStructuresModVariables.MapVariables
					.get(world).random_tick_potion_start = CreateStructuresModVariables.MapVariables.get(world).random_tick_potion + 40;
			CreateStructuresModVariables.MapVariables.get(world).syncData(world);
		}
		CreateStructuresModVariables.MapVariables
				.get(world).random_tick_potion = CreateStructuresModVariables.MapVariables.get(world).random_tick_potion + 1;
		CreateStructuresModVariables.MapVariables.get(world).syncData(world);
	}
}
