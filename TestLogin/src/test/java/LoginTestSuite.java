import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({LoginPageAccessibilityTest.class, LoginPositiveTest.class})
public class LoginTestSuite {
}
