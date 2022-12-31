
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createstructures.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.createstructures.client.model.Modelgas_mask_war_Converted;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CreateStructuresModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelgas_mask_war_Converted.LAYER_LOCATION, Modelgas_mask_war_Converted::createBodyLayer);
	}
}
