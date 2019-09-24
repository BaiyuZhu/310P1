package projectPack1;

import java.util.ArrayList;

public class FlightMap {

	/***
	 * 
	 * @param start
	 * @param end
	 * @param edgeList
	 * @param visited
	 * @param Ans
	 * @param cost
	 * @return
	 */
	public ArrayList<String> traceRoute(String start, String end, ArrayList<Edges> edgeList, ArrayList<String> visited, ArrayList<String> Ans, int cost){
		
		if(checkCityExist(visited, start)) {
			return null;
		}
		visited.add(start);
		Ans.add(start);
		
		if(start.equals(end)) {
			Ans.add(Integer.toString(cost));
			return Ans;
		}
		
		ArrayList<Edges> allEdges = giveEdges(edgeList, start);
		for(int i = 0; i < allEdges.size(); i++) {
			Edges theEdge = allEdges.get(i);
			ArrayList<String> possibleAns = traceRoute(theEdge.getEnd(), end, edgeList, visited, copy(Ans), cost+theEdge.getCost());
			if(possibleAns != null) {
				return possibleAns;
			}
		}
		
		return null;
	}
	
	/***
	 * 
	 * @param old
	 * @return
	 */
	public ArrayList<String> copy(ArrayList<String> old){
		
		ArrayList<String> copyList = new ArrayList<String>();
		for(int i = 0; i < old.size(); i++) {
			copyList.add(old.get(i));
		}
		
		return copyList;
	}
	
	/***
	 * 
	 * @param theList
	 */
	public void printList(ArrayList<String> theList) {
		
		for(int i = 0; i < theList.size(); i++) {
			System.out.print(theList.get(i) + " ");
		}
	}
	
	/***
	 * 
	 * @param edgeList
	 * @param name
	 * @return
	 */
	public ArrayList<Edges> giveEdges(ArrayList<Edges> edgeList, String name){
		
		ArrayList<Edges> relevantEdges = new ArrayList<Edges>();
		
		for(int i = 0; i < edgeList.size(); i++) {
			if(name.equals(edgeList.get(i).getSource())) {
				relevantEdges.add(edgeList.get(i));
			}
		}
		
		return relevantEdges;
	}
	
	/***
	 * 
	 * @param cityList
	 * @param name
	 * @return
	 */
	public boolean checkCityExist(ArrayList<String> cityList, String name) {
	
		for(int i = 0; i < cityList.size(); i++) {
			if(cityList.get(i).equals(name)) {
				return true;
			}
		}
	
		return false;
	}
	
	/***
	 * 
	 * @param cityList
	 * @param name
	 * @param original
	 */
	public void addCity(ArrayList<String> cityList, String name, String original) {
		
		if(!name.equals(original)&!checkCityExist(cityList, name)) {
			cityList.add(name);
		}
	}

}
