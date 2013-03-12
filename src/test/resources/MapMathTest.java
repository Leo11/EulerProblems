package test.resources;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import resources.MapMath;

public class MapMathTest {

	@Test
	public void testConvertNumberToString() {
		Map<Integer, Integer> testMap = MapMath.convertNumberString("1234");
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		resultMap.put(1, 4);
		resultMap.put(2, 3);
		resultMap.put(3, 2);
		resultMap.put(4, 1);
		for (int i : resultMap.keySet()) {
			Assert.assertEquals(resultMap.get(i), testMap.get(i));
		}
	}

	@Test
	public void testConverNumberToStringLargerNumber() {
		Map<Integer, Integer> testMap = MapMath
				.convertNumberString("37107287533902102798797998220837590246510135740250");
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		resultMap.put(1, 0);
		resultMap.put(2, 5);
		resultMap.put(3, 2);
		resultMap.put(4, 0);
		resultMap.put(5, 4);
		resultMap.put(6, 7);
		resultMap.put(7, 5);
		resultMap.put(8, 3);
		resultMap.put(9, 1);
		resultMap.put(10, 0);
		resultMap.put(11, 1);
		resultMap.put(12, 5);
		resultMap.put(13, 6);
		resultMap.put(14, 4);
		resultMap.put(15, 2);
		resultMap.put(16, 0);
		resultMap.put(17, 9);
		resultMap.put(18, 5);
		resultMap.put(19, 7);
		resultMap.put(20, 3);
		resultMap.put(21, 8);
		resultMap.put(22, 0);
		resultMap.put(23, 2);
		resultMap.put(24, 2);
		resultMap.put(25, 8);
		resultMap.put(26, 9);
		resultMap.put(27, 9);
		resultMap.put(28, 7);
		resultMap.put(29, 9);
		resultMap.put(30, 7);
		resultMap.put(31, 8);
		resultMap.put(32, 9);
		resultMap.put(33, 7);
		resultMap.put(34, 2);
		resultMap.put(35, 0);
		resultMap.put(36, 1);
		resultMap.put(37, 2);
		resultMap.put(38, 0);
		resultMap.put(39, 9);
		resultMap.put(40, 3);
		resultMap.put(41, 3);
		resultMap.put(42, 5);
		resultMap.put(43, 7);
		resultMap.put(44, 8);
		resultMap.put(45, 2);
		resultMap.put(46, 7);
		resultMap.put(47, 0);
		resultMap.put(48, 1);
		resultMap.put(49, 7);
		resultMap.put(50, 3);

		for (int i : resultMap.keySet()) {
			Assert.assertEquals(resultMap.get(i), testMap.get(i));
		}
	}
	
	@Test
	public void testEquals(){
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1,0);
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(1,0);
		Assert.assertTrue(MapMath.equals(map1, map2));
	}
	@Test
	public void testEquals2(){
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1,1);
		map1.put(2,0);
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(1,1);
		map2.put(2,0);
		Assert.assertTrue(MapMath.equals(map1, map2));
	}
	@Test
	public void testEquals3(){
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1,0);
		map1.put(2,0);
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(1,1);
		map2.put(2,0);
		Assert.assertFalse(MapMath.equals(map1, map2));
	}
	@Test
	public void testEquals4(){
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1,0);
		map1.put(2,1);
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(1,0);
		map2.put(2,1);
		map2.put(3,3);
		Assert.assertFalse(MapMath.equals(map1, map2));
	}
}
