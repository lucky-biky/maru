package project.maru;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MaruApplication {

  @Value("${spring.datasource.url}")
  private String datasourceURL;

  @Value("${server.port}")
  private String serverPort;

  public static void main(String[] args) {
    SpringApplication.run(MaruApplication.class, args);
  }

  @PostConstruct
  public void logEnvVariables() {
    log.debug("datasourceURL: {}", datasourceURL);
    log.debug("serverPort: {}", serverPort);

  }
}
