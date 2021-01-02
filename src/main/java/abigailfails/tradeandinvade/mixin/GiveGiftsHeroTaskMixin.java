package abigailfails.tradeandinvade.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.GiveHeroGiftsTask;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.util.Hand;

@Mixin(GiveHeroGiftsTask.class)
public class GiveGiftsHeroTaskMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/brain/task/GiveHeroGiftsTask;getGifts(Lnet/minecraft/entity/merchant/villager/VillagerEntity;)Ljava/util/List;"), method = "giveGifts")
    private void giveGifts(VillagerEntity villager, LivingEntity hero, CallbackInfo info) {
        villager.swingArm(Hand.MAIN_HAND);
    }
}
