package map;

public class RandomMazeSet {
	
	RandomMaze rm = new RandomMaze();
	public int set = 50;
	public int setMap = set * 2 + 1;
	public String str;
	public void set() {
		rm.setMap(setMap);
		str = "";
		for(int[] col : rm.map) {
			for(int row : col) {
				str += row + " ";
			}
			str += "\n";
		}
	}

}
