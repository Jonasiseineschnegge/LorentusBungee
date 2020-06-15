package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 03.01.2019.
 */
public class CMD_online extends Command {
    public CMD_online( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;


        if(strings.length == 0) {

            if( Vars.permission.get( proxiedPlayer.getName() ) <= 12 ) {

                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "Spielerzahl auf dem §aNetzwerk§7:" ) );
                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§e" + BungeeCord.getInstance().getPlayers().size()));

            }

        }else {
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cBenutze /online" ) );
        }

    }
}
