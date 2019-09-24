package projectPack1;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchMap {
	/***
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			findRoutes("input.txt");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/***
	 * 
	 * @param filename
	 * @throws Exception
	 */
	
	public static void findRoutes(String filename) throws Exception{
		FlightMap map = new FlightMap();
		
		File file = new File(filename);
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
		
		ArrayList<String> newVisited = new ArrayList<String>();
		ArrayList<String> newRoute = new ArrayList<String>();
		FileWriter fileWriter = new FileWriter("output.txt");
		
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("Destination   Flight Route from P   Total Cost");
		
		for(int i = 0; i < cityList.size(); i++) {
			
			ArrayList<String> aRoute = map.traceRoute(original, cityList.get(i), edgeList, map.copy(newVisited), map.copy(newRoute), 0);
			if(aRoute != null) {
				printWriter.print(cityList.get(i));
				printWriter.print("             ");
				
				for(int j = 0; j < aRoute.size()-1; j++) {
					printWriter.print(aRoute.get(j)+ " ");
				}
				
				for(int k = 0; k < cityList.size()-(aRoute.size()*2)+16; k++) {
					printWriter.print(" ");
				}
				
				printWriter.println("$"+aRoute.get(aRoute.size()-1));
			}
		}
		
		printWriter.close();
		sc.close();
	}
	
	
}
