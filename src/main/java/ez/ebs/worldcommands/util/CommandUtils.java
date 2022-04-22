package ez.ebs.worldcommands.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;


public class CommandUtils {
    static String cmd;
    public static void sendClientSideMessage(String message){
        if(MinecraftClient.getInstance().player != null){
            MinecraftClient.getInstance().player.sendMessage(Text.of("[WorldCMD]" + message), false);
        }
    }
    public static String commandSent(String command){
        cmd = command.toLowerCase();
        return cmd;
    }

    public static String getCmd() {
        return cmd;
    }
}
