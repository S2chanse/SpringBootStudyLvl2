package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    public void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        /**
         *
         * @param member 스프링 컨테이너 등록 X
         */
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("TestBean.setNoBean1 =" + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("TestBean.setNoBean2 =" + member);
        }


        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("TestBean.setNoBean3 =" + member);
        }
    }

}
