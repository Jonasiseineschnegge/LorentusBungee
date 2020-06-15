package de.codereader.cmd;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.scheduler.ScheduledTask;

import java.util.concurrent.TimeUnit;

import de.codereader.main.Main;
import de.codereader.utils.Vars;

/**
 * Created by Brewo on 03.01.2019.
 */
public class CMD_ping extends Command {
    public CMD_ping( String name ) {
        super( name );
    }

    private int count = 0;


    @Override
    public void execute( CommandSender commandSender, String[] strings ) {
        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) commandSender;
        ScheduledTask scheduledTask = null;

        if ( strings.length == 0 ) {

            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "Dein §ePing§7:"));
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§e" + proxiedPlayer.getPing() + " ms"));

        } else {
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Benutze: §b/ping"));
        }
    }
}
