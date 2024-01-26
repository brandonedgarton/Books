import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitProject {
	
	@Test
	public void test_JUnit() {
		System.out.println("Let's check this string");
		String str1 = "Let's check this string";
		assertEquals("Let's check this string", str1);
	}
}
