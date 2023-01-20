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
        @Bean(initMethod = "init")//destroyMethod를 셋팅 안해줘도, close,shutdown 함수를 자동으로 호출한다.
        public NetworkClient networkClient(){
            NetworkClient nc = new NetworkClient();
            System.out.println("LifeCycleConfig.networkClient url setter");
            nc.setUrl("https://www.naver.com");
            return nc;
        }
    }
}
