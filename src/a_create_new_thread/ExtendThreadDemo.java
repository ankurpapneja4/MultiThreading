package a_create_new_thread;

import java.util.stream.IntStream;

public class ExtendThreadDemo {
	
	
	public static class WorkerThread extends Thread{
		
		public WorkerThread() {
			setName(WorkerThread.class.getSimpleName());
			setPriority(MAX_PRIORITY);
		}
		@Override
		public void run() {
			System.out.println("Executing Thread : " + Thread.currentThread().getName());
			IntStream
				.range(1, 100)
				.forEach(System.out::println);
		}
		
		@Override
		public void start() {
			System.out.println("Starting main thread");
			super.start();
		}
	}
	
	
	public static void main(String[] args) {
		new WorkerThread()
					.start();
	}
	

}
