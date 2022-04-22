package ez.ebs.worldcommands.client;

import ez.ebs.worldcommands.command.CommandManager;
import net.fabricmc.api.ClientModInitializer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class WorldCommandsClient implements ClientModInitializer {
    public static String CMDPrefix = "!";
    CommandManager commandManager = new CommandManager();

    @Override
    public void onInitializeClient() {

    }

}
