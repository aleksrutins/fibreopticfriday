import "jsr:@std/dotenv/load";
import { Client, Embed } from "jsr:@harmony/harmony";

const client = new Client({
  intents: ["GUILDS", "GUILD_MESSAGES"],
});

Deno.cron("Send message", "0 17 * * 5", async () => {
  await client.channels.sendMessage(
    "general",
    new Embed({
      image:
        "https://media1.tenor.com/m/159UhFAYBWEAAAAC/fiber-optic-friday-eat-the-optic-cable.gif",
    }),
  );
});

client.connect();
