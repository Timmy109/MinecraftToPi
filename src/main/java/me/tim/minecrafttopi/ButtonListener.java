package me.tim.minecrafttopi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.DataOutputStream;
import java.net.Socket;

public class ButtonListener implements Listener {

    @EventHandler
    public void onPress(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();

        String msg = e.getMessage().toLowerCase();


        switch (msg) {
            case "red":
                sendData("red");
                p.sendMessage("You turned on the red LED");
                consolelog("red");
                break;
            case "green":
                sendData("green");
                p.sendMessage("You turned on the green LED");
                consolelog("green");
                break;
            case "yellow":
                sendData("yellow");
                p.sendMessage("You turned on the yellow LED");
                consolelog("yellow");
                break;
        }

    }

    public static void sendData(String data) {

        try {

            Socket s = new Socket(MinecraftToPi.getInstance().getConfig().getString("address"),
                    MinecraftToPi.getInstance().getConfig().getInt("port"));

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeBytes(data);
            dout.flush();
            dout.close();
            s.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void consolelog(String s) {
        System.out.println(s);
    }
}

