package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 03.01.2019.
 */
public class CMD_youtube extends Command {
    public CMD_youtube( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {
        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;

        if(strings.length == 0) {

            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Dies sind unsere §5YouTuber-Rang §7Anforderungen:" ) );
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + " §7§ Mindestens §e100 §7Abonnenten. ") );
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + " §7§ Mindestens §e1 §7Video von dem §7SanityMC.de §7Netzwerk") );
            proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + " §7§ Eine 'relativ' §aaktive §7Community.") );

        }
    }
}
