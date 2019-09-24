package projectPack1;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchMapTest {

	SearchMap newmap = new SearchMap();
	
	@Test
	public void testFindRoutes() {
		final File expected = new File("output2.txt");
		try {
			newmap.findRoutes("input.txt");
			File output = new File("output.txt");
			Scanner sc1 = new Scanner(expected);
			Scanner sc2 = new Scanner(output);
			
			while(sc1.hasNextLine() || sc2.hasNextLine()) {
				assertEquals(sc1.nextLine(), sc2.nextLine());
			}
			
			sc1.close();
			sc2.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
