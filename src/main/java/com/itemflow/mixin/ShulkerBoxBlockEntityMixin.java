package com.itemflow.mixin;

import com.itemflow.Utils.ChestClosedCallback;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShulkerBoxBlockEntity.class)
public class ShulkerBoxBlockEntityMixin
{
    @Inject(at = @At("TAIL"), method = "stopOpen")
    public void onClose(ContainerUser containerUser, CallbackInfo ci)
    {
        if (containerUser instanceof Player player)
        {
            ChestClosedCallback.EVENT.invoker().invoke(player);
        }
    }
}
