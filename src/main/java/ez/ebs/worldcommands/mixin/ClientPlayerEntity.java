package ez.ebs.worldcommands.mixin;

import ez.ebs.worldcommands.client.WorldCommandsClient;
import ez.ebs.worldcommands.command.CommandManager;
import ez.ebs.worldcommands.util.CommandUtils;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.network.ClientPlayerEntity.class)
public class ClientPlayerEntity {
    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    public void sendChatMessage(@NotNull String message, CallbackInfo CI){
        if(message.startsWith(WorldCommandsClient.CMDPrefix)){
            CommandUtils.commandSent(message);
            CommandManager.checkRunCommand();
            CI.cancel();
        }
    }
}
