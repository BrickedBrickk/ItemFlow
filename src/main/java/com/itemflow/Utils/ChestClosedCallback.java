package com.itemflow.Utils;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;

@FunctionalInterface
public interface ChestClosedCallback
{
    void invoke(Player player);

    Event<ChestClosedCallback> EVENT = EventFactory.createArrayBacked(ChestClosedCallback.class,
            (listeners) -> (player) ->
            {
                for (ChestClosedCallback listener : listeners)
                {
                    listener.invoke(player);
                }
            });
}
