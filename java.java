import java.net.*;
import java.io.*;

import com.google.gson.Gson;
import java.util.Map;
import java.util.HashMap;

public class YoozSeen {
    private String key;
    private String baseUrl = "https://api.yoozseen.ir/api/v1/";

    public YoozSeen(String apiKey) {
        this.key = apiKey;
    }

    private String post(Map<String, Object> data) throws Exception {
        URL url = new URL(baseUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        Gson gson = new Gson();
        String body = gson.toJson(data);

        OutputStream os = conn.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String balance() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("key", key);
        data.put("action", "balance");
        return post(data);
    }

    public String services() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("key", key);
        data.put("action", "services");
        return post(data);
    }

    public String status(String orderId) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("key", key);
        data.put("action", "status");
        data.put("order_id", orderId);
        return post(data);
    }

    public String addOrder(Map<String, Object> params) throws Exception {
        Map<String, Object> data = new HashMap<>(params);
        data.put("key", key);
        data.put("action", "add");
        return post(data);
    }

    // ==========================
    // Example Usage
    // ==========================
    public static void main(String[] args) throws Exception {
        YoozSeen api = new YoozSeen("xxxxxxxxx");

        System.out.println("Balance: " + api.balance());
        System.out.println("Services: " + api.services());
        System.out.println("Status: " + api.status("1500035"));

        Map<String, Object> boostOrder = new HashMap<>();
        boostOrder.put("service", "id service");
        boostOrder.put("link", "link boost");
        boostOrder.put("quantity", 100);
        System.out.println("Boost Order: " + api.addOrder(boostOrder));

        Map<String, Object> likesOrder = new HashMap<>();
        likesOrder.put("service", "id service");
        likesOrder.put("link", "@username");
        likesOrder.put("quantity", 50);
        likesOrder.put("row", 1);
        likesOrder.put("column", 1);
        likesOrder.put("speed", 0);
        likesOrder.put("startdelay", 0);
        likesOrder.put("interval", 0);
        System.out.println("Likes Order: " + api.addOrder(likesOrder));

        Map<String, Object> reactionOrder = new HashMap<>();
        reactionOrder.put("service", "id service");
        reactionOrder.put("link", "post link");
        reactionOrder.put("quantity", 30);
        reactionOrder.put("reaction", "👍");
        reactionOrder.put("speed", 0);
        reactionOrder.put("startdelay", 0);
        reactionOrder.put("interval", 0);
        System.out.println("Reaction Order: " + api.addOrder(reactionOrder));
    }
}
