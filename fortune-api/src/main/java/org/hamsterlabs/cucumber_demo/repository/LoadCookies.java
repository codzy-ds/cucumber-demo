package org.hamsterlabs.cucumber_demo.repository;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
public class LoadCookies {

    List<CookieJson> cookieJar = new ArrayList<>();

    @PostConstruct
    public void loadCookies() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:quotes/*");

        for (Resource resource : resources) {
            try (InputStream inputStream = resource.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                List<String> lines = reader.lines().collect(Collectors.toList());
                StringBuilder quoteBuilder = new StringBuilder();
                String signature = "";
                String category = resource.getFilename();

                for (String line : lines) {
                    if (line.trim().startsWith("--")) {
                        signature = line.trim();
                    } else if (line.trim().equals("%")) {
                        cookieJar.add(new CookieJson(quoteBuilder.toString().trim(), category, signature));
                        quoteBuilder.setLength(0); // Reset the builder for the next quote
                        signature = ""; // Reset the signature for the next quote
                    } else {
                        quoteBuilder.append(line).append("\n");
                    }
                }

                // Add the last quote if the file does not end with %
                if (quoteBuilder.length() > 0) {
                    cookieJar.add(new CookieJson(quoteBuilder.toString().trim(), category, signature));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CookieJson getRandomCookie() {
        int random = (int) (Math.random() * cookieJar.size());
        return cookieJar.get(random);
    }

    public List<CookieJson> getAllCookies() {
        return cookieJar;
    }

    public void saveCookie(CookieJson cookie) {
        cookieJar.add(cookie);
    }
}
