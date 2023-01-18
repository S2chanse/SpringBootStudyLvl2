package hello.core.beanDefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 메타정보 확인")
    void findAppBean() {
        String[] arrStr = applicationContext.getBeanDefinitionNames();
        for (String s : arrStr) {
           BeanDefinition beanDefinition = applicationContext.getBeanDefinition(s);
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
               System.out.printf("beanDefinition = %s \r\n",s);
           }
        }
    }
}
