public class Calculator {
    
	private int result;

    public Calculator() {
        
    	this.result = 0;
    	
    }

    public int getResult() {
        
    	return result;
    	
    }

    public void clear() {
        
    	this.result = 0;
    	
    }

    public int add(int num1, int num2) {
        
    	result = num1 + num2;
        
    	return result;
    	
    }

    public int subtract(int num1, int num2) {
        
    	result = num1 - num2;
        
    	return result;
    	
    }

    public int multiply(int num1, int num2) {
        
    	result = num1 * num2;
        
    	return result;
    	
    }

    public int divide(int dividend, int divisor) {
        
    	if (divisor == 0) {
            
    		throw new IllegalArgumentException("Cannot divide by zero");
        }
        
    	result = dividend / divisor;
        
    	return result;
    	
    }
}
