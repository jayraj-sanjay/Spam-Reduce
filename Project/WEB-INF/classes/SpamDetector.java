import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpamDetector {

	public static String getDigest(String word) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] digest = md.digest(word.getBytes());
		return Arrays.toString(digest);
	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("13.txt"))));
		BufferedWriter bw1 = new BufferedWriter (
				new OutputStreamWriter(new FileOutputStream(new File("obfuscate.txt"))));

		System.out.println("Started obfuscating the email");
		String line = "";
		while ((line = br1.readLine()) != null) {
			line = line.toLowerCase();
			String words[] = line.split(" ");
			String opLine = "";
			for (String w : words) {
				w = getDigest(w);
				if (opLine.equals(""))
					opLine += w;
				else
					opLine += " " + w;
			}
			bw1.write(opLine);
			bw1.newLine();
		}
		bw1.close();
		br1.close();
		System.out.println("Done obfuscating the email");

		System.out.println("Started Spam checking");
		br1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("obfuscate.txt"))));
		boolean is_spam = false;
		List<String> spams = new ArrayList<>();
		String email_line = "";
		String spam_line = "";
		while ((email_line = br1.readLine()) != null) {

			String encoded_spam_line = "";
			String plain_spam_line = "";
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("spamwords.txt"))));

			while ((spam_line = br2.readLine()) != null) {
				if (spam_line.trim().length() > 0) {
					spam_line = spam_line.toLowerCase();
					String words[] = spam_line.split(" ");
					plain_spam_line = spam_line;

					for (String w : words) {
						w = getDigest(w);
						if (encoded_spam_line.equals("")) {
							encoded_spam_line += w;

						} else {
							encoded_spam_line += " " + w;
						}
					}
					if (email_line.contains(encoded_spam_line)) {
						if (!spams.contains(plain_spam_line))
							spams.add(plain_spam_line);
						//is_spam = true;
					}
				}

				encoded_spam_line = "";
				plain_spam_line = "";

			}
			
			if (spams.size()>4) 
				is_spam = true;

			br2.close();

		}

		System.out.println("Spam checking done");
		System.out.println("RESULT : IS SPAM ? : " + is_spam);
		if (is_spam) {
			System.out.println("The mail is spam due to the following words");
			for (String spam : spams) {
				System.out.println(spam);
			}
		}
		br1.close();
	}

}
