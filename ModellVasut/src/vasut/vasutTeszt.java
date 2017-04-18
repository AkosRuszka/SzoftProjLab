package vasut;

import static org.junit.Assert.*;

import org.junit.Assert;

import vasut.*;
import org.junit.Test;

public class vasutTeszt {
	Proto p = new Proto();
	@Test
	public void test1() {
		p.loadInput(1);
		p.loadOutput(1);
		p.teszt1();		
		Assert.assertTrue(p.logCheck());
	}	
	public void test2() {
		p.loadInput(2);
		p.loadOutput(2);
		p.teszt2();		
		Assert.assertTrue(p.logCheck());
	}	
	public void test3() {
		p.loadInput(3);
		p.loadOutput(3);
		p.teszt3();		
		Assert.assertTrue(p.logCheck());
	}	
	public void test4() {
		p.loadInput(4);
		p.loadOutput(4);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}	
	public void test5() {
		p.loadInput(5);
		p.loadOutput(5);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}
	public void test6() {
		p.loadInput(6);
		p.loadOutput(6);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}
	public void test7() {
		p.loadInput(7);
		p.loadOutput(7);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}
	public void test8() {
		p.loadInput(8);
		p.loadOutput(8);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}
	public void test9() {
		p.loadInput(9);
		p.loadOutput(9);
		try {
			p.teszt456789();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Assert.assertTrue(p.logCheck());
	}
	public void test10() {
		p.loadInput(10);
		p.loadOutput(10);
		p.teszt10111213();			
		Assert.assertTrue(p.logCheck());
	}
	public void test11() {
		p.loadInput(11);
		p.loadOutput(11);
		p.teszt10111213();			
		Assert.assertTrue(p.logCheck());
	}
	public void test12() {
		p.loadInput(12);
		p.loadOutput(12);
		p.teszt10111213();			
		Assert.assertTrue(p.logCheck());
	}
	public void test13() {
		p.loadInput(13);
		p.loadOutput(13);
		p.teszt10111213();			
		Assert.assertTrue(p.logCheck());
	}
	public void test14() {
		p.loadInput(14);
		p.loadOutput(14);
		p.teszt14();			
		Assert.assertTrue(p.logCheck());
	}
	public void test15() {
		p.loadInput(15);
		p.loadOutput(15);
		p.teszt15();			
		Assert.assertTrue(p.logCheck());
	}
}
