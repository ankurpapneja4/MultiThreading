package a_create_new_thread;

import java.util.stream.IntStream;

public class RunnableInterfaceDemo {

	public static void main(String[] args) {
		
		//1.Create thread
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				//Print Current thread name
				System.out.println("Executing thread " + Thread.currentThread().getName());
				
				//Do some task
				IntStream
					.range(1, 100)
					.forEach(System.out::println);
				
			}
				
		});
		
		//2. Set thread properties
		thread.setName("PrintRangeThread");
		thread.setPriority(Thread.MIN_PRIORITY);
		
		
		
		//3. Start thread
		thread.start();
		
		
	}
	
	
	
	
}
