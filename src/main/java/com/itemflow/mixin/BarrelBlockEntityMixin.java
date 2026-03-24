package com.itemflow.mixin;

import com.itemflow.Utils.ChestClosedCallback;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.entity.ContainerUser;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BarrelBlockEntity.class)
public class BarrelBlockEntityMixin
{
    @Inject(at = @At("TAIL"), method = "onClose")
    public void onClose(ContainerUser containerUser, CallbackInfo ci)
    {
        if (containerUser instanceof PlayerEntity player)
        {
            ChestClosedCallback.EVENT.invoker().invoke(player);
        }
    }
}
