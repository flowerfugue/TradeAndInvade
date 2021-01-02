package abigailfails.tradeandinvade.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.InteractWithDoorTask;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;

@Mixin(InteractWithDoorTask.class)
public class OpenDoorTaskMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/DoorBlock;openDoor(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Z)V"), method = "startExecuting")
    private void startExecuting(ServerWorld worldIn, LivingEntity entityIn, long gameTimeIn, CallbackInfo info) {
        entityIn.swingArm(Hand.MAIN_HAND);
    }
}
