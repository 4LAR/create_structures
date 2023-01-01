
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createstructures.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.createstructures.client.model.Modelcustom_model_rag;
import net.mcreator.createstructures.client.model.Modelcustom_model_gasmask_improved;
import net.mcreator.createstructures.client.model.Modelcustom_model_gasmask;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CreateStructuresModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcustom_model_gasmask_improved.LAYER_LOCATION, Modelcustom_model_gasmask_improved::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model_rag.LAYER_LOCATION, Modelcustom_model_rag::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model_gasmask.LAYER_LOCATION, Modelcustom_model_gasmask::createBodyLayer);
	}
}
