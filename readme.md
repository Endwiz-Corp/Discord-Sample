# Discord Bot Base
Discord Bot Base is a base for creating discord bots in Java with Discord4J API

## How to use Discord Bot Base
### Step 1: Configure the bot
1. Download and import the project on your IDE
2. Create a new bot on [Discord Developer Portal](https://discord.com/developers/applications/). 
3. Go to the Main.java class and modify the name of the bot, the prefix, the token, the owner id
4. Now you can run the bot

### Step 2: Add commands
1. Go to the package 'fr.endwiz.bot.base.commands' and create a new class
2. Extands your class of 'BaseCmd'
3. Write 
```
    public yourClass() {
        super(CmdCategory.{category}, CmdPermission.{perm}, Arrays.asList(Names Commands)), aliases;
   }

   @Override
   public void execute(Context context) {
       {action}
   }
```
4. Go to CmdManager.java and add your class commands on the constructor

## Discord4J help
### Send Message
Classic Message:
```
channel.createMessage("Pong!").block();
```
Embed Message:
```
channel.createEmbed(spec -> 
  spec.setColor(Color.RED)
    .setAuthor("setAuthor", URL, IMAGE_URL)
    .setImage(IMAGE_URL)
    .setTitle("setTitle/setUrl")
    .setUrl(ANY_URL)
    .setDescription("setDescription\n" +
      "big D: is setImage\n" +
      "small D: is setThumbnail\n" +
      "<-- setColor")
    .addField("addField", "inline = true", true)
    .addField("addFIeld", "inline = true", true)
    .addField("addFile", "inline = false", false)
    .setThumbnail(IMAGE_URL)
    .setFooter("setFooter --> setTimestamp", IMAGE_URL)
    .setTimestamp(Instant.now())
).block();
```

Add reaction:
```
channel.createMessage("Pong!").block().addReaction(ReactionEmoji.unicode("✅")).block();
```

## Help
If you need help, you can send me a private message on my [Twitter](https://twitter.com/EndwizJoestar) (English and French only).
You can also go to the [Github](https://github.com/Discord4J/Discord4J) or [Discord](https://discord.gg/NxGAeCY) of Discord4J for more help!
