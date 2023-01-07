package b_uncaught_exception_handler_for_thread;

public class UncaughtExceptionHandlerDemo {
	public static void main(String[] args) {
		
		//1. Create thread
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				throw new RuntimeException("Unknown error occoured");
			}
		});
		
		//2. Define default exception handler
		thread.setName("Misbehaving thread");
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						String.format("%s : Exception in thread [%s] cause [%s]", 
								e.getClass().getName(),thread.getName(),e.getMessage()));
				
			}
			
		});
		
		
		thread.start();;
	}
}
