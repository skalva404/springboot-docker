package io.vertx.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties("springboot-vertx")
public class Config {

    private String prop = "default value";

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    @Autowired
    private Environment environment;

    public int httpPort() {
        return environment.getProperty("http.port", Integer.class, 8080);
    }
}
