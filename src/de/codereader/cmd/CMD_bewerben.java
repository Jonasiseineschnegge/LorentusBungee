package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 02.01.2019.
 */
public class CMD_bewerben extends Command {
    public CMD_bewerben( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;

        if(strings.length == 0) {

            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Du kannst dich folgendermaßen §abewerben:" ) );
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + " §7Auf unserem Teamspeak: §aLorentus.de"));


        }

    }
}
