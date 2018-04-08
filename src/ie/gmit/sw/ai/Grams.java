package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grams{

	private static Grams instance;
	private String fileName;
	private Map<String, Integer> gramsMap;
	private long count;

	//Map the grams into a map 
	private Grams(String fileName) {
		
		this.fileName = fileName;
		this.gramsMap = new HashMap<String, Integer>();
		
	}

	public static Grams getInstance(String fileName) {
		
		return (instance == null) ? new Grams(fileName) : instance;
		
	}

	public void loadGrams() throws Exception {

		Stream<String> stream = Files.lines(Paths.get(this.fileName));
		
		gramsMap = stream.map(tmp -> tmp.split(" ")).collect(Collectors.toMap(tmp -> tmp[0], tmp -> Integer.parseInt(tmp[1])));
		
		stream.close();
		
		this.count = gramsMap.values().stream().mapToLong(i -> i).sum();
		
	}

	
	public double scoreText(String cipheredText) {
		
		double score = 0;

		int range = (cipheredText.length() > 800) ? 742 - 4 : cipheredText.length() - 4;

		for (int i = 0; i < range; i++) {
			score += Math.log10((double) (((gramsMap.get(cipheredText.substring(i, i + 4)) != null)
					? gramsMap.get(cipheredText.substring(i, i + 4))
					: 1)) / this.count);
		}
		return score;
	}
}