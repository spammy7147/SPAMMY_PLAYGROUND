package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {
    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);

        /**
         * 커맨드 라인 옵션
         * --url=devdb --username=dev_user --password=dev_pw
         *
         * 자바 시스템 속성
         * -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw
         *
         * 우선순위
         * - 유연한것이 우선권을 가진다.
         * - 법위가 좁은것이 우선권을 가진다.
         */
    }

}
