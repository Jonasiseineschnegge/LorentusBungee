package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 03.01.2019.
 */
public class CMD_ts extends Command {
    public CMD_ts( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {


        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;

        if(strings.length == 0) {

            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Unsere §bTeamSpeak³ §7IP:" + " §bLorentus.de" ) );


        }

    }
}
