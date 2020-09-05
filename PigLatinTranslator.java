import java.util.Scanner;

/**
 * @author Linh Vo
 * @date 11/06/2019
 * @purpose This program will ask the user to enter a phrase to translate into
 *          Pig Latin.
 */
public class PigLatinTranslator {
	public static final String CODE = "ay";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a phrase: ");
		String phrase = input.nextLine();

		String piglatinPhrase = "";

		phrase = removeSymbol(phrase); // clean up original phrase
		String[] original = phrase.trim().split("\\s+"); // convert original phrase string to a string array of words

		// loop for translating each word in the phrase
		for (int a = 0; a < original.length; a++) {
			String translatedPhrase = translate(original[a]);
			if (a == original.length - 1) {
				piglatinPhrase += translatedPhrase; // add no space when the last word in the phrase is translated
			} else
				piglatinPhrase += translatedPhrase + " "; // add space after each translated word
		}

		System.out.println("Your phrase translated to Pig Latin: " + piglatinPhrase);
		input.close();
	}

	/*
	 * create method to replace all special symbols with white space to separate 2
	 * words.
	 */
	public static String removeSymbol(String word) {
		word = word.replaceAll("[^a-zA-Z\\s]", " ");

		return word;
	}

	/* create method to check if a letter is a vowel or consonant */
	public static boolean isVowel(char letter) {
		if ("AEUIOaeuio".indexOf(letter) != -1)
			return true;
		else
			return false;
	}

	/* create method to translate input phrase to pig latin */
	public static String translate(String phrase) {
		int position = -1; // position of first vowel
		char letter;

		// loop to check each letter in the phrase if it is vowel or consonant
		for (int index = 0; index < phrase.length(); index++) {
			letter = phrase.charAt(index);
			if (isVowel(letter)) {
				position = index;
				break;
			}
		}
		/*
		 * Add "ay" to the end when the word starts with a vowel or has no vowels at
		 * all. Move consonants to the end of the word and add "ay" if word starts with
		 * consonant.
		 */
		if (position == 0 || position == -1) {
			return phrase + CODE;
		} else {
			String afterVowel = phrase.substring(position);
			String beforeVowel = phrase.substring(0, position);
			return afterVowel + beforeVowel + CODE;
		}
	}

}
