package org.hamsterlabs.cucumber_demo.persistence.repository;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.persistence.entities.CookieEntity;
import org.hamsterlabs.cucumber_demo.persistence.entities.FileLoadedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
public class LoadCookies {

    private final CookieRepository cookieRepository;
    private final FileLoadedRepository fileLoadedRepository;

    @Autowired
    public LoadCookies(CookieRepository cookieRepository, FileLoadedRepository fileLoadedRepository) {
        this.cookieRepository = cookieRepository;
        this.fileLoadedRepository = fileLoadedRepository;
    }

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
                if(fileLoadedRepository.findByFileName(category).isPresent()) {
                    continue;
                }

                for (String line : lines) {
                    if (line.trim().startsWith("--")) {
                        signature = line.trim();
                    } else if (line.trim().equals("%")) {
                        cookieRepository.save(new CookieEntity(quoteBuilder.toString().trim(), category, signature));
                        quoteBuilder.setLength(0); // Reset the builder for the next quote
                        signature = ""; // Reset the signature for the next quote
                    } else {
                        quoteBuilder.append(line).append("\n");
                    }
                }

                // Add the last quote if the file does not end with %
                if (quoteBuilder.length() > 0) {
                    cookieRepository.save(new CookieEntity(quoteBuilder.toString().trim(), category, signature));
                }
                fileLoadedRepository.save(new FileLoadedEntity(category, new Date()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
