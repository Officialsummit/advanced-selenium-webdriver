package base_configs;

public class TestUtilities extends BaseTest {
	
	//static sleep 
	protected  void sleepMethod(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
