package lin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class lin2 {
    static Map<Integer, String> response = new HashMap<>();
    static Map<String, String> data = new HashMap<>();

    public static void main(String[] args) throws IOException {

        response.put(200, "OK");
        response.put(201, "CREATED");
        response.put(403, "FORBIDDEN");
        response.put(404, "NOT_FOUND");
        response.put(405, "METHOD_NOT_ALLOWED");

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }

                // todo : 시작
                if (method.equals("POST")) {
                    post(url);
                } else if (method.equals("GET")) {
                    get(url);
                }
            }
        }
    }

    public static void post(String url) {
        if (url.split("/").length >= 2) {


            if (url.split("/")[1].equals("users") && !url.split("/")[2].isEmpty()) {
                data.put(url.split("/")[2], "");
            }

            if (url.contains("value")) {
//                data.put(url.split("/")[2], );
            }

        }
    }

    public static void get(String url) {
        if (!url.contains("data") && url.contains("users") && !url.split("/")[2].isEmpty()) {
            System.out.println(405 + " " + response.get(405)); //405 에러 발생
        }

        if (url.split("/")[1].equals("users") && url.split("/")[3].equals("data")) {

        }
    }
}
