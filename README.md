# FlirteeBot

A novel Twitch bot that lets viewers flirt with one another.

## IMPORTANT
This repository contains both the [source](https://github.com/CodeHuset/FlirteeBot/tree/main/src/main/java) and [built](https://github.com/CodeHuset/FlirteeBot/tree/main/build/SNAPSHOT/Initial%20Build) files. You can compare the structure of both to ensure they are the same if you wish

Pre-requisites:
You will need a computer running Java 11 or newer. To see your Java version, open your Terminal/Command Prompt/Powershell and run `java -version`

If you have any questions, please leave an issue on GitHub.

## How to run

Open your termninal, command prompt or powershell.

Run the command `java -jar FlirteeBotFileName.jar oauth:yourTwitchIRCAuthToken yourTwitchUsername`

For example, `java -jar FlirteeBot.jar oauth:notavalidtoken haxial`

These **MUST** be in this order.

You can get an oauth string for a Twitch Account [here](https://twitchapps.com/tmi/). Generate on the account you want the bot to use.

You must then edit the source code, under Flirtee.java, specifically [this line](https://github.com/CodeHuset/FlirteeBot/blob/main/src/main/java/Flirtee.java#L19) to reflect the username of the Twitch account you are using. Name is NOT case sensitive.


You must also have the `flirts.txt` file in the same directory as the Jar File being run
