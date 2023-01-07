package e_multithreaded_calculation_example;
import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread thread1 
        		= new PowerCalculatingThread(base1, power1);
        
        PowerCalculatingThread thread2 
        		= new PowerCalculatingThread(base2, power2);
        
        thread1.start();
        thread2.start();
        
        try {
        	System.out.println("Waiting for calculation to complete. Max 2 Sec");
            thread1.join(2000);
            thread2.join(2000);
        } catch (InterruptedException e) {
        	System.out.println("Prematurely Exiting");
        }
        finally {
        	System.out.println("Resuming main thread");
            thread1.interrupt();
            thread2.interrupt();
        }
        
        	
		
        
        result = thread1.getResult()
        				.add(thread2.getResult());
        
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
        	for( BigInteger i = BigInteger.ONE; 
        			i.compareTo(power) <= 0 ;
        				i=i.add(BigInteger.ONE)) 
        	{
        			if(this.isInterrupted()) {
        				System.out.println("Thread "+ this +" interrupted. Prematurely returning");
        				result = BigInteger.ONE;
        				break;
        			}
        				
        			result = result.multiply(base);
        	}
        		
        }
    
        public BigInteger getResult() { return result; }
    }
    
    public static void main(String x[]) {
    	System.out.println(
    			new ComplexCalculation()
    				.calculateResult(
    						new BigInteger("400000254785698785456"), new BigInteger("200324323342344234"), 
    						new BigInteger("34597897854656215125453654785"), new BigInteger("2134234234245")));
    }
}