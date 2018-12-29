package cc.funkemunky.daedalus.api.data;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

public class DataManager {
    private List<PlayerData> dataObjects = Lists.newArrayList();

    public DataManager() {
        Bukkit.getOnlinePlayers().forEach(player -> addData(player.getUniqueId()));
    }

    public PlayerData getPlayerData(UUID uuid) {
        return dataObjects.stream().filter(data -> data.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    public void addData(UUID uuid) {
        dataObjects.add(new PlayerData(uuid));
    }

    public void removeData(UUID uuid) {
        dataObjects.stream().filter(data -> data.getUuid().equals(uuid)).forEach(data -> dataObjects.remove(data));
    }
}
