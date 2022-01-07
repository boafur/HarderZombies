package me.rubberboa.harderzombies.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoorBlock.class)
abstract class DoorBlockMixin {
	@Inject(method = "isWoodenDoor(Lnet/minecraft/block/BlockState;)Z", at = @At(value = "RETURN"), cancellable = true)
	private static void isWoodenDoor(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(state.getBlock() instanceof DoorBlock);
	}
}
