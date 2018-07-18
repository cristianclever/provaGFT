import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gft.dish.processor.DishProcessor;

public class TesteResultados {

	@Test
	public void test1() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("morning, 1, 2, 3");
		assertTrue(result.equals( "eggs, toast, coffee"));
		
	}
	
	@Test
	public void test2() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("morning, 2, 1, 3");
		assertTrue(result.equals( "eggs, toast, coffee"));
		
	}	
	
	@Test
	public void test3() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("morning, 1, 2, 3, 4");
		assertTrue(result.equals( "eggs, toast, coffee, error"));
		
	}	
	
	@Test
	public void test4() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("morning, 1, 2, 3, 3, 3");
		assertTrue(result.equals( "eggs, toast, coffee(x3)"));
		
	}	

	
	@Test
	public void test5() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("night, 1, 2, 3, 4");
		assertTrue(result.equals( "steak, potato, wine, cake"));
		
	}	

	@Test
	public void test6() {
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("night, 1, 2, 2, 4");
		assertTrue(result.equals( "steak, potato(x2), cake"));
		
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testRule1() {
		
		//You must enter time of day as â€œmorningâ€� or â€œnightâ€�
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("night2, 1, 2, 2, 4");

		
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testRule2() {
		
		//You must enter a comma delimited list of dish types with at least one selection
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("night");

		
	}		
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testRule3() {
		
		//You must enter a comma delimited list of dish types with at least one selection
		
		DishProcessor dp = new DishProcessor();
		
		String result = dp.resolve("night, 1,2,3,3f");

		
	}			
	
	
	
	
	
	
}
