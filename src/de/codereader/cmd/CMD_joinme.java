package de.codereader.cmd;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import de.codereader.main.Main;
import de.codereader.utils.Vars;

/**
 * Created by Brewo on 02.01.2019.
 */
public class CMD_joinme extends Command {

    private static Map<ProxiedPlayer, Long> joinMeList = new HashMap<>();

    public CMD_joinme( String name ) {
        super( name );
        ProxyServer.getInstance().getScheduler().schedule(Main.instance , () -> {
            for ( Map.Entry<ProxiedPlayer, Long> entry : new ArrayList<>( joinMeList.entrySet() ) ) {
                if ( entry.getValue() <= System.currentTimeMillis() ) {
                    joinMeList.remove( entry.getKey() );
                }
            }
        }, 50, 50, TimeUnit.MILLISECONDS );
    }

    @Override
    public void execute( CommandSender commandSender, String[] strings ) {

        ProxiedPlayer proxiedPlayer = ( ProxiedPlayer ) commandSender;

        if ( strings.length == 0 ) {

            if ( Vars.permission.get( proxiedPlayer.getName() ) <= 12 ) {
                if ( joinMeList.containsKey( proxiedPlayer ) ) {
                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "D" ) );
                    return;
                }
                joinMeList.put( proxiedPlayer, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis( 1 ) );
                for ( ProxiedPlayer all : BungeeCord.getInstance().getPlayers() ) {

                    all.sendMessage( new TextComponent( Vars.prefix + "§7--- §6§lJOIN ME §7---" ) );
                    all.sendMessage( new TextComponent( Vars.prefix + " " ) );

                    TextComponent textComponent = new TextComponent();

                    textComponent.setText( Vars.prefix + "§7Join dem Spieler §a§l" + proxiedPlayer.getDisplayName() +
                            " §7zum Server §b§l" + proxiedPlayer.getServer().getInfo().getName() + " §7nach: " + "§6§lKLICK" );

                    textComponent.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT,
                            new ComponentBuilder( "§7Klicke, um dem Spieler " + proxiedPlayer.getDisplayName() + "§7 nachzujoinen." ).create() ) );


                    ClickEvent clickEvent = new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/joinme " + proxiedPlayer.getName() );
                    textComponent.setClickEvent( clickEvent );

                    all.sendMessage( textComponent );
                    all.sendMessage( new TextComponent( Vars.prefix + " " ) );
                    all.sendMessage( new TextComponent( Vars.prefix + "§7--- §6§lJOIN ME §7---" ) );
                }
            } else {
                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cBitte versuche es sp§ter erneut." ) );
            }
        } else if ( strings.length == 1 ) {

            ProxiedPlayer target = BungeeCord.getInstance().getPlayer( strings[0] );

            if ( target != null ) {

                if(!joinMeList.containsKey( target )){
                    // TODO: 04.01.2019 send message
                    return;
                }
                Server targetServer = target.getServer();

                if ( targetServer != null ) {

                    if ( targetServer.getInfo() != proxiedPlayer.getServer().getInfo() ) {

                        proxiedPlayer.connect( targetServer.getInfo() );

                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Auf Server §b§l" + targetServer.getInfo().getName() + "§7 verbunden." ) );
                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§7Zu Spieler: §a§l" + target.getDisplayName() ) );

                    } else {
                        proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDu bist bereits auf diesem Server!" ) );
                    }
                } else {
                    proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDieser Server existiert nicht mehr!" ) );
                }

            } else {
                proxiedPlayer.sendMessage( new TextComponent( Vars.prefix + "§cDieser Spieler ist nicht online." ) );
            }
        }
    }
}

