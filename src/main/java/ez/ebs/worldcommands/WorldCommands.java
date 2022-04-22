package ez.ebs.worldcommands;

import ez.ebs.worldcommands.command.Command;
import ez.ebs.worldcommands.command.CommandManager;
import ez.ebs.worldcommands.command.commands.NearestBiome;
import ez.ebs.worldcommands.command.commands.SetSeed;
import meteordevelopment.orbit.EventBus;
import net.fabricmc.api.ModInitializer;

import java.util.ArrayList;

import static ez.ebs.worldcommands.command.CommandManager.addCommand;

public class WorldCommands implements ModInitializer {
    public static long seed;
    public static ArrayList<Command> commands = new ArrayList<>();
    public static EventBus EVENT_BUS = new EventBus();
    CommandManager COMMAND_MANAGER = new CommandManager();

    @Override
    public void onInitialize() {

        //add commands
        addCommand(new NearestBiome());
        addCommand(new SetSeed());
//        addCommand(new NearestItem());
    }
}
