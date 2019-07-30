package interview.LRU;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Integer> CHANNEL_ID_MAP = new HashMap();

    public static void main(String[] args) {
        channelId2payChannel(1);
    }

    public static String channelId2payChannel(int channelId) {
        if (channelId == CHANNEL_ID_MAP.get(null)) {
            return "";
        }

        return "";
    }
}
