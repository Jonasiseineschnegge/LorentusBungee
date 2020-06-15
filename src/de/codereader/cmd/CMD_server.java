package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 02.01.2019.
 */
public class CMD_server extends Command {


    public CMD_server( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) commandSender;

        if ( strings.length == 1 ) {

            if ( Vars.permission.get( proxiedPlayer.getName() ) <= 2 ) {

                ServerInfo target = BungeeCord.getInstance().getServerInfo( strings[0] );
                if ( target != null ) {

                    if ( proxiedPlayer.getServer().getInfo() != target ) {

                        proxiedPlayer.connect( target );
                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Du hast dich auf Server §b" + target.getName() + "§7 verbunden." ) );

                    } else {
                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDu bist bereits auf diesem Server." ) );
                    }
                } else {
                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDieser Server existiert nicht." ) );
                }
            } else {
                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDu hast dafür nicht genug Rechte." ) );
            }

        } else {

            if ( strings.length == 0 ) {

                if ( Vars.permission.get( proxiedPlayer.getName() ) <= 2 ) {

                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Alle derzeit §aaktiven §7Server:" ) );

                    for ( ServerInfo allServer : BungeeCord.getInstance().getServers().values() ) {

                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + " §7§ §a" + allServer.getName() ) );
                    }
                }else {
                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDu hast dafür nicht genug Rechte." ) );
                }
            }
        }
    }
}
