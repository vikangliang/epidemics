import com.huag.epidemics.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void Test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:bean.xml");
        IUserService service= (IUserService) applicationContext.getBean("userServiceImpl");
        service.test();
    }
}
