import com.group5.Group5Application;
import com.group5.Mapper.UserMapper;
import com.group5.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Group5Application.class)
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
    }

}
