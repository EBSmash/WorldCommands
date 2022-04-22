package ez.ebs.worldcommands.command.commands;

import ez.ebs.worldcommands.WorldCommands;
import ez.ebs.worldcommands.command.Command;
import ez.ebs.worldcommands.util.CommandUtils;

public class SetSeed extends Command {
    public SetSeed() {
        super("setseed","set the world seed", "!setseed <seed>");
    }

    @Override
    public void runCommand(String[] args) {
        if(args.length==2){
            WorldCommands.seed = Long.parseLong(args[1]);
            CommandUtils.sendClientSideMessage("Set seed to " + args[1]);
        }
        else{
            CommandUtils.sendClientSideMessage(this.getSyntax());
        }
    }
}
