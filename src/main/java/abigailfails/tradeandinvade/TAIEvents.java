package abigailfails.tradeandinvade;

import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TradeAndInvade.MODID)
public class TAIEvents {
    @SubscribeEvent
    public static void onEntityTick(LivingUpdateEvent event) {
        if (event.getEntity() instanceof VillagerEntity) {
            VillagerEntity villager = (VillagerEntity) event.getEntity();
            villager.updateArmSwingProgress();
        }
    }
}
