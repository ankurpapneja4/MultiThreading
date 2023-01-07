package d_daemon_thread;

public class DaemonThreadDemo {

	// Create thread
	public static class BlockingThread extends Thread {

		public BlockingThread() {
			this.setName(this.getClass().getSimpleName());
			
			//This thread is marked as daemon
			//Therefore it will terminate as soon as main thread terminated
			//Program will not wait for daemon thread to finish
			this.setDaemon(true);
		}

		@Override
		public void run() {
			System.out.println("Running Thread : "+ Thread.currentThread());
			try {
				// Sleep 1 hour
				Thread.sleep(1L * 60 * 60 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Premature termination");
			}
		}
	}

	// MAIN
	public static void main(String x[]) throws InterruptedException{

		Thread blockingThread = new BlockingThread();
		blockingThread.start();

		System.out.println("Running Thread : "+ Thread.currentThread());
		Thread.sleep(500);

	}
	
	
}
