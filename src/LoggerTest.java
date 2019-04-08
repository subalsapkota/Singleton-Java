import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class LoggerTest {

	@Test
	public void testLogger() throws IOException {
		
		Logger newLogger = Logger.getInstance();
		newLogger.log("Opened");
		newLogger.log("Appended");
		Logger newerLogger = Logger.getInstance();
		newerLogger.log("Appended again");
		newLogger.close();
		
		assertEquals(newLogger, newerLogger);
	}
	
}
