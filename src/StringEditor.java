package src;

/**
 * The StringEditor class provides methods for editing strings, specifically for
 * the preparation of encryption and after decryption operations.
 */
public class StringEditor {
    private static StringBuilder strBuilder = new StringBuilder();

    /**
     * Edits the input string after decryption.
     *
     * @param str The input string to be edited.
     * @return The edited string after decryption.
     */
    public static String editStringAfterDecryption(String str) {
        strBuilder.setLength(0);
        strBuilder.append(str);
        // ein replace von "ae" zusammenhängend funktioniert nicht da indexOf nur nach
        // dem ertsen buchstaben sucht -> in repalceall nach substring suchen
        replaceAllWindowSearch("ae", "ä");// ä");
        replaceAllWindowSearch("oe", "ö");// ö");
        replaceAllWindowSearch("ue", "ü");// ü");
        return strBuilder.toString();
    }

    /**
     * Edits the input string for encryption.
     *
     * @param str The input string to be edited.
     * @return The edited string for encryption.
     */
    public static String editStringForEncryption(String str) {
        strBuilder.setLength(0);
        strBuilder.append(str);
        // replaceAllWindowSearch(" ", "");

        // PROBLEM: nach dem einlesen einer txt, schein "ä" als "ã¤" gelesen zu werden
        // somit wird kein "ä" gefunden -> replace auch "ã¤"
        replaceAllWindowSearch("ä", "ae");
        replaceAllWindowSearch("ã¤", "ae");
        replaceAllWindowSearch("ã„", "ae");
        // replaceAllWindowSearch("¤", "");

        replaceAllWindowSearch("ö", "oe");
        replaceAllWindowSearch("ã¶", "oe");
        // replaceAllWindowSearch("¶", "");

        replaceAllWindowSearch("ü", "ue");
        replaceAllWindowSearch("ã¼", "ue");
        replaceAllWindowSearch("ãœ", "ue");
        // replaceAllWindowSearch("¼", "");

        replaceAllWindowSearch("ß", "ss");
        replaceAllWindowSearch("ãÿ", "ss");
        // replaceAllWindowSearch("ÿ", "");

        return strBuilder.toString();
    }

    /**
     * Performs a test edit on the input string.
     * Irrellevant for the final Product
     *
     * @param str The input string to be edited.
     * @return The edited string after the test edit.
     */
    public static String editTest(String str) {
        strBuilder.append(str);
        replaceAllWindowSearch("llo", "sos");
        return strBuilder.toString();
    }

    /**
     * Replaces all occurrences of a substring with a new string in the input StringBuilder.
     *
     * @param toReplace The substring to be replaced.
     * @param newString The new string to replace the substring with.
     */
    private static void replaceAllWindowSearch(String toReplace, String newString) {
        while (stringContains(toReplace, strBuilder.toString()) != -1) {
            int k = stringContains(toReplace, strBuilder.toString());
            strBuilder.replace(k, k + toReplace.length(), newString);
        }
    }

    /**
     * Finds the index of the first occurrence of a substring in a string.
     *
     * @param toFind         The substring to find.
     * @param originalString The original string to search within.
     * @return The index of the first occurrence of the substring, or -1 if not
     *         found.
     */
    private static int stringContains(String toFind, String originalString) {
        int i = 0;
        int j = i + toFind.length();

        while (j <= originalString.length()) {
            if (originalString.substring(i, j).equals(toFind)) {
                return i;
            }

            i++;
            j++;
        }

        return -1;
    }
}
