# Build Frequency
By: Aswin Nair
CISC 3130 - TY2
Brooklyn College

## Summary

**Build Frequency** is a java application created for an assignment in CISC 3130 (Data Structures) at Brooklyn College. The application takes in one input file [lyrics.txt](https://github.com/AswinTorch/3130-assignment3/blob/master/lyrics.txt) as the source and creates a frequency list of the words in the file. It then outputs this list into a new file named [output.txt](https://github.com/AswinTorch/3130-assignment3/blob/master/output.txt).


## Setup

Instructions for running the application:
1.  Clone the repository to your local machine. Here are [instructions](https://help.github.com/en/articles/cloning-a-repository) to do this.
2. Then, go into the cloned directory in terminal/command-line (`cd <repo folder>`)
3. Run the command `javac BuildFrequency.java`
4. Finally, run the command `java BuildFrequency < lyrics.txt` 

**Note:** You can edit the [lyrics.txt](https://github.com/AswinTorch/3130-assignment3/blob/master/lyrics.txt) file to your liking and input any sort of text such as song lyrics to be analyzed. For this specific example, the file is populated with lyrics from the song, ["44 Bars" by Logic](https://genius.com/Logic-44-bars-lyrics).

## Under The Hood
The application was written in Java, using the HashMap data structure in Java to store the words from the input. 

* First, the words from the input file are taken, accounting for their case and unneeded punctuation.
* Then, the words are added one-by-one to a HashMap with their respective frequencies changing through every iteration.
* It is then sorted from highest to lowest frequency.
* Finally, the words and their frequencies are outputted into a new file.

The reason the HashMap was used in this case was because of its simplicity of key-value pairs and its relevance to the problem. The frequency list needs to have two things: words and its frequency. Therefore, it is easy to see why a HashMap would best solve the problem. However, HashMaps make no guarantee as to the order of the map. As such, a function was created to sort the values from highest to lowest using the available sort method in the Java Collections class. 

The output for the file should look like:
```
31: the
21: i
18: and
```
and so on.