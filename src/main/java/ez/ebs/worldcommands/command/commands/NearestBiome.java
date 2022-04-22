package ez.ebs.worldcommands.command.commands;

import com.seedfinding.mcbiome.source.OverworldBiomeSource;
import ez.ebs.worldcommands.WorldCommands;
import ez.ebs.worldcommands.command.Command;
import ez.ebs.worldcommands.util.CommandUtils;
import com.seedfinding.mccore.version.MCVersion;

import java.util.Locale;

public class NearestBiome extends Command {
    public NearestBiome() {
        super("biome", "finds nearest biome of a certain type", "!bnearest <biomename>");
    }
    OverworldBiomeSource overworldBiomeSource = new OverworldBiomeSource(MCVersion.v1_18_2, WorldCommands.seed);

    int spiralX, spiralZ;
    int steps = 12;
    Boolean found = false;
    public void runCommand(String[] args) {
        if (args.length<2) {
            CommandUtils.sendClientSideMessage(this.getSyntax());
            found = true;
        }
        while (!found){
            if (Math.abs(spiralX) <= Math.abs(spiralZ) && (spiralX != spiralZ || spiralX >= 0))
                spiralX += ((spiralZ >= 0) ? steps : -steps);
            else
                spiralZ += ((spiralX >= 0) ? -steps : steps);
            CommandUtils.sendClientSideMessage(spiralX + " " +spiralZ);
            if(overworldBiomeSource.getBiome(spiralX,0,spiralZ).getName().toLowerCase(Locale.ROOT).equals(args[1].toLowerCase(Locale.ROOT))){
                CommandUtils.sendClientSideMessage("Biome found at " + spiralX + " " +spiralZ);
                found = true;
            }

        }
    }


}


