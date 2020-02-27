import com.huag.epidemics.dao.IuserDao;
import com.huag.epidemics.pojo.UserInfo;
import com.huag.epidemics.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");
        IUserService service = (IUserService) applicationContext.getBean("userServiceImpl");
        service.test();
    }

    @org.junit.Test
    public void testMybatis() throws Exception{
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();
        IuserDao iuserDao=sqlSession.getMapper(IuserDao.class);
        List<UserInfo> userInfoList=iuserDao.getUserInfo();
        for(UserInfo userInfo:userInfoList){
            System.out.println(userInfo.getUserId()+" "+userInfo.getAccount());
        }
        sqlSession.close();
        in.close();
    }
}
