package c_thread_termination_with_interrupt;

public class ExplicitlyHandlingInterruptDemo {

	//Create thread
	public static class BlockingThread extends Thread{
		
		public BlockingThread(){
			this.setName(this.getClass().getSimpleName());
		}
		
		@Override
		public void run() {
			while(true) {
				
				//check if current thread is interrupted then handle explicitly
				if(this.isInterrupted()) {
					onInterrupt();
					break;
				}
					

				pingServer();
			}
		}
		
		public void pingServer() {
			System.out.println("Response From Server : OK");
		}
		
		public void onInterrupt() {
			System.out.println("Thread interrupted. Cleaning system resources");
		}
		
	}
	
	public static void main(String x[]) {
		
		
		Thread blockingThread 
					= new BlockingThread();
		
		blockingThread.start();
		
		//explicitly interrupt thread
		blockingThread.interrupt();
		
	}
}
