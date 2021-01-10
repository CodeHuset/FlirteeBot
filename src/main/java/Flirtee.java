import org.jibble.pircbot.PircBot;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Flirtee extends PircBot {

    //Creates a Random Class instance, used for randomising the flirts
    Random r = new Random();

    //define the Bot
    public Flirtee(){
        //Change "FlirteeBot" to the name of the bot or account you are using.
        this.setName("FlirteeBot");
        this.isConnected();
    }


    //This calls when the bot sees a message. This does NOT include /me messages
    @Override
    protected void onMessage(String channel, String sender, String login, String host, String message) {
        String[] s = message.split(" ");

        if(message.toLowerCase().startsWith(":flirt")){
            //Try to load the flirts from file. Because it loads on command, you can update the flirts.txt file in real time with no issues
            List<String> fl = null;
            try {
                fl = Files.readAllLines(Paths.get(System.getProperty("user.dir") + File.separator + "flirts.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Replies if Shann0nc is the flirting party, and JayDee is NOT the recipient
            String[] sh = {"Damn Shan, why you gotta disrespect Jade like that?", "Does Jade know about this?","Hmm, Jade won't be too pleased","You're going to cheat on Jade with {u}?", "I'm not angry, Shannon, not upset, not mad, just disappointed"};
            String re = message.replace(":flirt ","");
            String[] a = fl.toArray(new String[fl.size()]);
            int aa = r.nextInt(a.length);
            int sa = r.nextInt(sh.length);
            if(sender.equalsIgnoreCase("shann0nc")){
                if(!(re.contains("jade")||re.toLowerCase().contains("x_jaydee_x")||re.toLowerCase().contains("jaydee"))){
                    sendAction(channel, sh[sa].replace("{u}", re));
                }else{

                    sendAction(channel, re+", "+a[aa]);

                }
            }else{
                //This calls if the person tries to flirt with the creator of this Bot
                if((re.toLowerCase().contains("haxial"))){
                    String[] com = {"adorable","kind","sweet","awesome","hot","attractive","blessed","fine"};
                    int cc = r.nextInt(com.length);
                    sendAction(channel, "Sorry "+sender+", but I don't feel comfortable flirting with the person who gave me life. Even if it was someone as "+com[cc]+" as you who asked me to.");
                }else{
                    //This calls if all went well.
                    sendAction(channel, re+", "+a[aa]);
                }
            }
        }

        //This is the :lb2kg command, used like :lb2kg 20
        //The bot will then convert 20lb to its value in KG
        if(message.startsWith(":lb2kg")){
            Double lb = Double.parseDouble(s[1]);
            Double kg = lb * 0.45;
            sendAction(channel, "Converting " + s[1] + "(lb) to kg is: " + kg);
        }

        //The bot will pick between the options listed. Options cannot have a space, as the space character is the separator
        if(message.startsWith(":pick")){
            int pick = r.nextInt(s.length-1);
            String[] picks = message.replace(":pick ","").split(" ");
            sendAction(channel, "Out of all the options, for me I would say "+picks[pick]);

        }

    }

}
