import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Test;

class GreetingTest {
	
	private Greeting greeting;

	@Test
	public void getMessage_initializedWithGreeting_returnsGreeting() {
		
		greeting = new Greeting("Hello world!");
		
		assertThat(greeting.getMessage(), is("Hello world!"));
	}

}
