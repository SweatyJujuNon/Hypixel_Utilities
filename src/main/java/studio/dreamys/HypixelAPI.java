package studio.dreamys;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class HypixelAPI {
    public static String key = "f84fb818-27dc-491d-89b4-bb467a20bb2a";

    private static Gson gson = new Gson();
    
    public static double getBedwarsLevel(UUID uuid) {
        double level = -1;
        LinkedTreeMap data = gson.fromJson(request(String.format("https://api.hypixel.net/player?key=%s&uuid=%s",key,uuid)), LinkedTreeMap.class);
        if ((boolean)data.get("success")) {
            level = (double) ((LinkedTreeMap) ((LinkedTreeMap) data.get("player")).get("achievements")).get("bedwars_level");
        }
        return level;
    }

}
