package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 31.12.2018.
 */
public class CMD_teamonline extends Command {


    public CMD_teamonline( String teamonline ) {
        super( teamonline );
    }

    @Override
    public void execute( CommandSender sender, String[] args ) {

        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) sender;

        if ( Vars.permission.get( proxiedPlayer.getName() ) <= 7 ) {

            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Folgende §eTeammitglieder §7sind online: " ) );

            for ( ProxiedPlayer all : BungeeCord.getInstance().getPlayers() ) {

                if ( Vars.permission.get( all.getName() ) <= 7 ) {

                    proxiedPlayer.sendMessage( new TextComponent( "   §7§ §e" + all.getDisplayName() ) );

                }
            }
        }
    }
}
