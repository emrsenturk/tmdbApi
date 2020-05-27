I used TMDB Api for this project




- [] MVMM Data binding , liveData
- [] Kotlin 
- [-] Dependency Injection (dagger2, Koin)— this is an optional part
- [] Bitbucket or github preffered by me 
- [] Retrofit for network 
- [] Constraint Layout 
- [] Glide for img
- [] Recylerview 
- [] Google Paging library (infinitive scroll list) 

import java.io.*;

public class ReadLineByLineExample1 {
    public static void main(String args[]) {
        try {
            File file = new File("Demo.txt"); // creates a new file instance
            FileReader fr = new FileReader(file); // reads the file
            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
            String line;
            char[] chars;
            while ((line = br.readLine()) != null) {
                /*
                 * String[] arrOfStr = line.split(":", 2); for (String a : arrOfStr)
                 * System.out.println(a);
                 */
                chars = line.toCharArray();
                // System.out.println(line);
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == ':') {
                        chars[i + 1] = '"';
                    }
                    if (chars[i] == '\t') {
                        System.out.println("");
                        if (chars[i - 1] != '\t') {
                            chars[i] = '"';
                            i++;
                        }

                    }
                    // System.out.println(chars[i]);
                }

                sb.append("{\n");
                sb.append('"');
                sb.append(chars); // appends line to string buffer
                sb.append('"'); // line feed
                sb.append("\n}");
                sb.append("\n"); // line feed
            }
            fr.close(); // closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString()); // returns a string that textually represents the object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
