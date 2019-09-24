package projectPack1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class FlightMapTest {

	ArrayList<String> testCityList = new ArrayList<String>();
	ArrayList<Edges> testEdgeList = new ArrayList<Edges>();
	ArrayList<String> testAns = new ArrayList<String>();
	FlightMap map = new FlightMap();
	
	@Test
	public void testTraceRoute() {
		try {
			
			
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			String original = sc.nextLine();
			ArrayList<Edges> edgeList = new ArrayList<Edges>();
			ArrayList<String> cityList = new ArrayList<String>();
			
			while(sc.hasNextLine()) {
				
				String[] aline = sc.nextLine().split(" ");
				String cityName = aline[0];
				String cityName2 = aline[1];
				int cost = Integer.parseInt(aline[2]);
				edgeList.add(new Edges(cityName, cityName2, cost));
				
				map.addCity(cityList, cityName, original);
				map.addCity(cityList, cityName2, original);
				
			}
			
			testAns.add("P");
			testAns.add("W");
			testAns.add("Y");
			testAns.add("Z");
			testAns.add("1150");
			
			ArrayList<String> visit = new ArrayList<String>();
			ArrayList<String> Answer = new ArrayList<String>();
			assertEquals(testAns, map.traceRoute("P", "Z", edgeList, visit, Answer, 0));
			
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void testCopy() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("b");
		
		System.out.println("Mark here.");
		
		assertEquals(testList, map.copy(testList));
	}

	@Test
	public void testPrintList() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("b");
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    map.printList(testList);
		assertEquals("a b b ", outContent.toString());
		
	}

	@Test
	public void testGiveEdges() {
		Edges edge1 = new Edges("A", "B", 1);
		Edges edge2 = new Edges("B", "C", 2);
		Edges edge3 = new Edges("C", "A", 2);
		Edges edge4 = new Edges("A", "D", 2);
		
		ArrayList<Edges> expected = new ArrayList<Edges>();
		expected.add(edge1);
		expected.add(edge4);
		
		testEdgeList.add(edge1);
		testEdgeList.add(edge2);
		testEdgeList.add(edge3);
		testEdgeList.add(edge4);
		
		
		assertEquals(expected, map.giveEdges(testEdgeList, "A"));
	}

	@Test
	public void testCheckCityExist() {
		testCityList.add("a");
		testCityList.add("b");
		
		assertEquals(true, map.checkCityExist(testCityList, "a"));
		assertEquals(false, map.checkCityExist(testCityList, "c"));
	}

	@Test
	public void testAddCity() {
		ArrayList<String> emptyList = new ArrayList<String>();

		emptyList.add("a");
		map.addCity(testCityList, "a", "p");
		assertEquals(emptyList, testCityList);
		
		map.addCity(testCityList, "a", "p");
		assertEquals(emptyList, testCityList);
		
		map.addCity(testCityList, "p", "p");
		assertEquals(emptyList, testCityList);
	}

}
