import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;

public class Bot {

    final String token = "";


    public static void main(String[] args) throws IOException, IrcException {

        Flirtee flirtee = new Flirtee();

        if(args[0].equals("--help")){
            System.out.println("To use this bot, run the jar file as \njava -jar FlirteeBot.jar oauth:yourTwitchIRCAuthToken yourTwitchChannelName\n\nFor example:\njava -jar FlirteeBot.jar oauth:aninvalidtoken haxial");
            System.exit(0);
        }else{
            flirtee.setVerbose(true);
            flirtee.connect("irc.chat.twitch.tv", 6667, args[0]);
            //The following two lines allow the bot to function better, but add no functionality yet. If you are proficient with pIRCBot and Java, you can add further commands in the Flirtee.java file
            flirtee.sendRawLine("CAP REQ :twitch.tv/commands");
            flirtee.sendRawLine("CAP REQ :twitch.tv/membership");
            flirtee.joinChannel("#"+args[1]);
        }
    }
}
