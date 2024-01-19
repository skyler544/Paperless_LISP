package at.fhtw.swen3.paperless.integration.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class HealthChecker {
    @Value("${healthcheck.server}")
    private String serverAddress;

    @Value("${healthcheck.port}")
    private String port;

    @Value("${healthcheck.endpoint}")
    private String endpoint;

    public boolean isHealthy() {
        return false;
    }

    public String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    public int getResponseCode() throws IOException {
        try {
            URL url = new URL(this.address());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            return con.getResponseCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
