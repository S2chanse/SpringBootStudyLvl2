package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycle {
    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext ac =new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient nc = ac.getBean("networkClient",NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient nc = new NetworkClient();
            System.out.println("LifeCycleConfig.networkClient url setter");
            nc.setUrl("https://www.naver.com");
            return nc;
        }
    }
}
