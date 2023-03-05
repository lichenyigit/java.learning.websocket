import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    static final Logger log = LoggerFactory.getLogger(Test.class.getName());
    public static void main(String[] args) {
        log.info("发生错误");
        log.warn("发生错误");
        log.trace("发生错误");
        log.error("发生错误");
    }
}
