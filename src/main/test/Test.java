import com.huag.epidemics.dao.IuserDao;
import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;


import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");
        IUserService service = (IUserService) applicationContext.getBean("userServiceImpl");
        service.test();
    }



}
