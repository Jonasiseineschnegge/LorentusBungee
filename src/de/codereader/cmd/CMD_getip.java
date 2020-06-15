package de.codereader.cmd;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.net.InetAddress;

import de.codereader.utils.Vars;

/**
 * Created by Brewo on 02.01.2019.
 */
public class CMD_getip extends Command {

    public CMD_getip( String getip ) {
        super( getip );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) commandSender;

        if ( strings.length == 1 ) {

            ProxiedPlayer target = BungeeCord.getInstance().getPlayer( strings[0] );

            if ( Vars.permission.get( proxiedPlayer.getName() ) <= 2 ) {

                if ( target != null ) {

                    InetAddress targetIp = target.getAddress().getAddress();

                    StringBuilder stringBuilder = new StringBuilder( targetIp.toString() );
                    stringBuilder.deleteCharAt( 0 );
                    String resultString = stringBuilder.toString();

                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Die IP des Spielers §a" + target.getDisplayName() + "§7 ist: §a" + resultString) );

                } else {
                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDieser Spieler ist nicht online." ) );
                }
            }else {
                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDu hast nicht genug Rechte, um dies auszuf§hren." ) );
            }

        }else {
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Benutze: §b/getip <Spieler>" ) );
        }


    }
}

