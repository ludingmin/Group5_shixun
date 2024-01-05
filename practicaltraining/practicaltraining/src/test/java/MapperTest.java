import com.group5.Group5Application;
import com.group5.Mapper.UserMapper;
import com.group5.Service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.filters.IdentityOutputFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@SpringBootTest(classes = Group5Application.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        System.out.println("123");
    }

    @Test
    void sa(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time_string = sdf.format(date);
//       System.out.println(time_string);
        Date date1;
        try {
             date1 = sdf.parse(time_string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void s1(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        System.out.println(time);
    }


//    void save(){
//        Date time = new java.sql.Date(new java.util.Date().getTime());
//        int active = userService.active(time);
//        System.out.println(active);
//    }


    @Test
    void test1(){
        userService.getActNewUserByMonth();
    }


}
