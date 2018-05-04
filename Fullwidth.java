public class Fullwidth {

  public static void main(String[] args) {
    System.out.println(fullwidth(args));
  }

  private static String fullwidth(String[] words) {
    return String.join(" ", words)
                 .chars()
                 .mapToObj(c -> widenChar(c)) // IntStream... sigh
                 .collect(StringBuilder::new,
                          StringBuilder::append,
                          StringBuilder::append)
                 .toString();
  }

  /**
   * Returns the fullwidth version of a character.
   * If no fullwidth version exists, returns the character.
   *
   * @param c The character to make fullwidth.
   * @return The fullwidth character, if possible; otherwise, c.
   */
  private static char widenChar(char c) {
    if (127 > c && c > 32) {
      c += 65248;
    }
    return c;
  }

  /**
   * Returns the fullwidth version of a character.
   * If no fullwidth version exists, returns the character.
   *
   * @param c The int representation of the character to make fullwidth.
   * @return The fullwidth character, if possible; otherwise, (char) c.
   */
  private static char widenChar(int c) {
    return widenChar((char) c);
  }
}
