package ez.ebs.worldcommands.command;

import java.util.ArrayList;

public abstract class Command {
    String name;
    String syntax;
    String description;

    public Command(String name,String description,String syntax){
        this.name = name;
        this.description = description;
        this.syntax = syntax;
    }

    public String getName() {
        return name;
    }
    public String getSyntax() {
        return syntax;
    }
    public void runCommand(String[] args) {

    }
}


