package ez.ebs.worldcommands.command.commands;

import com.seedfinding.mcbiome.source.OverworldBiomeSource;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mcfeature.loot.LootContext;
import com.seedfinding.mcfeature.loot.MCLootTables;
import com.seedfinding.mcfeature.loot.item.ItemStack;
import com.seedfinding.mcfeature.structure.*;
import com.seedfinding.mccore.version.MCVersion;
import ez.ebs.worldcommands.command.Command;
import ez.ebs.worldcommands.util.CommandUtils;
import net.minecraft.client.MinecraftClient;

import java.util.List;

import static ez.ebs.worldcommands.WorldCommands.seed;

//DOES NOT WORK

public class NearestItem extends Command {
    public NearestItem() {
        super("item", "finds nearest structure with specified items", "!item <structurename>");
    }
    OverworldBiomeSource overworldBiomeSource = new OverworldBiomeSource(MCVersion.v1_18_2, seed);
    ChunkRand chunkRand = new ChunkRand();


    @Override
    public void runCommand(String[] args) {
        BPos currentPosition = new BPos((int)MinecraftClient.getInstance().player.getX(), 0, (int)MinecraftClient.getInstance().player.getZ());
        double smallestDistance = Integer.MAX_VALUE;
        CPos closestStruct = new CPos(currentPosition);

        RuinedPortal ruinedPortal = new RuinedPortal(Dimension.OVERWORLD,MCVersion.v1_18_2);
        CPos closestRuinedPortal = ruinedPortal.getInRegion(seed,MinecraftClient.getInstance().player.getBlockX()%256,MinecraftClient.getInstance().player.getBlockZ()%256,chunkRand);

        chunkRand.setDecoratorSeed(seed, closestRuinedPortal.getX() * 16, closestRuinedPortal.getZ() * 16, 40005, MCVersion.v1_18_2);

        LootContext a1 = new LootContext(chunkRand.nextLong());
        List<com.seedfinding.mcfeature.loot.item.ItemStack> ItemList = MCLootTables.RUINED_PORTAL_CHEST.generate(a1);
        for(ItemStack itemStack : ItemList){
            if(itemStack.getItem().getName().equals(args[1])){
                CommandUtils.sendClientSideMessage(itemStack.getItem().getName());
            }
        }

    }
}
