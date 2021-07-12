import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDups {

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("spamwords.txt"))));
		String line = "";
		Set<String> spams = new LinkedHashSet<>();
		while  ((line=br.readLine())!=null) {
			line = line.toLowerCase();
			spams.add(line);
		}
		br.close();
		
		Iterator<String> it = spams.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
