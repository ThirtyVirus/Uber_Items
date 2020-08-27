package thirtyvirus.uber.helpers;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// an object that stores a name and string to describe the ability of an Uber Item. For display purposes only!
public class UberAbility {

    private String name;
    private AbilityType type;
    private String description = "This item wasn't given a description!";

    public UberAbility(String name, AbilityType type, String description) {
        this.name = name; this.type = type; this.description = description;
    }

    // convert the ability into Item Lore
    public List<String> toLore() {
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GOLD + "Item Ability: " + name + " " + ChatColor.YELLOW + ChatColor.BOLD + type.getText());

        List<String> desc = Arrays.asList(description.split("\n"));
        for (String item : desc) { item = ChatColor.GRAY + item; lore.add(item); }

        return lore;
    }

}
