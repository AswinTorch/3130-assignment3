
/******************************************************************************
 *
 *  Aswin Nair - CISC3130 - Assignment 3
 *
 *  Commands for running this file
 *  Compilation:  javac BuildFrequency.java
 *  Execution:    java BuildFrequency < lyrics.txt
 *
 *  Application that takes an input of song lyrics or any sort of text input
 *  and outputs a frequency list of the words from the input into a file
 *  named 'output.txt'
 *
 ******************************************************************************/

import java.util.*;
import java.io.*;

public class BuildFrequency {
  /**
   * sortValues - Function to sort the values in a HashMap from highest to lowest
   * frequency
   * 
   * @param - HashMap hm - HashMap with input words
   * @return - HashMap temp - sorted HashMap
   **/
  public static HashMap<String, Integer> sortValues(HashMap<String, Integer> hm) {
    // Creates a list from elements of the HashMap
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

    // Sorts the list
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return (o2.getValue()).compareTo(o1.getValue());
      }
    });

    // Puts the data from the sorted list into a hashmap
    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }

    // Returns the new sorted hashmap
    return temp;
  }

  public static void main(String[] args) throws IOException {
    // Creates scanner to take the input
    Scanner input = new Scanner(System.in);

    // Creates HashMap for the frequency list
    HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

    // Adds the words from the input file to the wordCount Hashmap
    while (input.hasNext()) {
      // Accounts for word case and punctuation
      String next = input.next().toLowerCase();
      String cleanNextWord = next.replaceAll("\\p{Punct}", "").toLowerCase();
      // Adds the next word to the HashMap with a value of 1 if word doesn't exist
      // already
      if (!wordCount.containsKey(cleanNextWord)) {
        wordCount.put(cleanNextWord, 1);
      } else {
        // If word exists already, replaces old entry and the value of the word is
        // increased by 1
        wordCount.put(cleanNextWord, wordCount.get(cleanNextWord) + 1);
      }
    }

    // Calls the sortValues function to sort the values and build a new HashMap
    HashMap<String, Integer> sortedHashMap = sortValues(wordCount);

    // Creates components to write to a file named "output.txt"
    PrintWriter printWriter = new PrintWriter(new FileWriter(new File("output.txt")));

    // Outputs the keys and values of the sorted HashMap as a frequency list to the
    // file
    for (String word : sortedHashMap.keySet()) {
      int count = sortedHashMap.get(word);
      printWriter.print(count + ": " + word + "\n");
    }

    // Closes the printwriter and scanner
    printWriter.close();
    input.close();

    // Prints message to console to confirm the output
    System.out.println("Frequency list successfully created and printed to file: output.txt");
  } // End of main

} // End of class BuildFrequency
