package Slack;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SlackNotificao {

    private static final String WEBHOOK_URL = "https://hooks.slack.com/services/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";

    public static void enviarAlert(String message) {
        try {
            String payload = "{\"text\": \"" + message + "\"}";

            byte[] postData = payload.getBytes(StandardCharsets.UTF_8);

            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData, 0, postData.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Mensagem enviada com sucesso.");
            } else {
                System.out.println("Falha ao enviar a mensagem. Código de resposta: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
