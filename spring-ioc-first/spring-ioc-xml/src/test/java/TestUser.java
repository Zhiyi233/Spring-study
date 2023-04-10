import com.atguigu.ioc.xml.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //get bean according to the id 方式一
        User user = (User) context.getBean("user");
        System.out.println("1: "+user);

        //方式二：According to the type
        //只能由一个bean，单实例匹配
        User user2 = context.getBean(User.class);
        System.out.println("2: "+user2);

        //方式三：id and type
        User user3 = context.getBean("user", User.class);
        System.out.println("3: "+user3);
    }
}
