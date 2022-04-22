package ez.ebs.worldcommands.command;

import com.google.common.eventbus.Subscribe;
import ez.ebs.worldcommands.WorldCommands;
import ez.ebs.worldcommands.client.WorldCommandsClient;
import ez.ebs.worldcommands.util.CommandUtils;

import java.util.ArrayList;
import java.util.List;
import static ez.ebs.worldcommands.WorldCommands.*;
import static ez.ebs.worldcommands.WorldCommands.commands;
import static ez.ebs.worldcommands.client.WorldCommandsClient.CMDPrefix;

public class CommandManager {

    public CommandManager(){
        EVENT_BUS.subscribe(this);

    }
    public static void addCommand(Command c){
        commands.add(c);
    }

    @Subscribe
    public static void checkRunCommand() {
        for (Command command : commands) {
            String[] args = CommandUtils.getCmd().split(" ");
            if (args[0].equalsIgnoreCase(CMDPrefix + command.getName())) {
                command.runCommand(args);
                return;
            }
        }
        CommandUtils.sendClientSideMessage("Invalid command try " + CMDPrefix + "commands");
    }

}
