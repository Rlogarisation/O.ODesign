/**
 * Demo file, it may not be correct and/or complete.  
 * Please watch the corresponding lecture(s) for more explanations.
 * 
 * @author ashesh
 */

package car;

public class classA {

	public void doSomething(Car car) {
		// incorrect
		String pcode = car.getOwner().getAddress().getPostcode();

		// correct
		String postcode = car.getCarPostcode();
		
	}
	
	
}
