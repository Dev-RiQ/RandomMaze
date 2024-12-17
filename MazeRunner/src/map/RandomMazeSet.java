package map;

import java.io.FileWriter;
import java.io.IOException;

public class RandomMazeSet {
	
	RandomMaze rm = new RandomMaze();
	public int set = 50;
	public int setMap = set * 2 + 1;
	public void set() {
		rm.setMap(setMap);
		String str = "";
		for(int[] col : rm.map) {
			for(int row : col) {
				str += row + " ";
			}
			str += "\n";
		}
		String filePath = "world01.txt";
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(str);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
