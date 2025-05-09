package hello.selector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ImportSelectorTest {

    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {

    }
    @Configuration
    @Import(HelloImportSelector.class)
    public static class SelectorConfig {

    }

    @Test
    void staticConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        Assertions.assertThat(bean).isNotNull();

    }

    @Test
    void selectorConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        Assertions.assertThat(bean).isNotNull();
    }
}
