package c_thread_termination_with_interrupt;

public class InterruptDemo {
	
	//Create thread
	public static class BlockingThread extends Thread{
		
		public BlockingThread(){
			this.setName(this.getClass().getSimpleName());
		}
		
		@Override
		public void run() {
			try{
				//Sleep 1 hour
				Thread.sleep(1L*60*60*1000);
			} catch (InterruptedException e) {
				System.out.println("Premature termination");
			}
		}
	}
	
	
	//main 
	public static void main(String x[]) {
		
		
		Thread blockingThread 
					= new BlockingThread();
		
		blockingThread.start();
		
		//"blockingThread" takes 1 hour to complete
		//Out program will not terminate until this thread completes execution 
		//or we explicitly interrupt this thread

		blockingThread.interrupt();
		
		
		
		
	}

}
