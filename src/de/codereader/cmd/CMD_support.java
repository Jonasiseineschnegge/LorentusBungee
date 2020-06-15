package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Brewo on 03.01.2019.
 */
public class CMD_support extends Command {
    public CMD_support( String name ) {
        super( name );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) commandSender;

        if ( strings.length == 0 ) {

            if ( Vars.permission.get( proxiedPlayer.getName() ) >= 8 ) {

                for ( ProxiedPlayer supporters : BungeeCord.getInstance().getPlayers() ) {

                    if ( Vars.permission.get( supporters.getName() ) == 5 ) {

                        TextComponent textComponent = new TextComponent();

                        textComponent.setText( Vars.prefix + "§7Der Spieler §a" + proxiedPlayer.getName() + "§7 benötigt §9support." );
                        textComponent.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT,
                                new ComponentBuilder( "§7Klicke, um dich zu §e" + proxiedPlayer.getName() + "§7 zu teleportieren" ).create() ) );
                        textComponent.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/goto " + proxiedPlayer.getName() ) );

                        supporters.sendMessage( textComponent );

                    }
                }

                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Es wurden alle aktiven §9§lSupporter §7benachrichtigt." ));

            }
        }

    }
}
