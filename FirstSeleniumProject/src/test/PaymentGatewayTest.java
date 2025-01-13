package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentGatewayTest {
	private ExecutorService executor;

    @BeforeClass
    public void setUp() {
        // Initialize ExecutorService to simulate concurrent users
        executor = Executors.newFixedThreadPool(5); // Simulate 5 users trying to buy the same item
    }

    @Test
    public void testMultipleUsersBuyingSameItem() {
        for (int i = 0; i < 5; i++) {
            // Each user will have a different username/password
            String username = "user" + (i + 1);
            String password = "password" + (i + 1);

            // Submit user tasks to the executor
            executor.submit(new UserFlow(username, password));
        }

        // Shut down the executor after all tasks have been completed
        executor.shutdown();
    }
}
