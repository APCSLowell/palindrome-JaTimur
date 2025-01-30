import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = {"test", "rotator","rewriter","nurses run","Madam, I'm Adam!", "A Man! A Plan! A Canal! Panama!"};
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++){
    if(isPalindrome(lowercaseNoSpace(lines[i]))==true){
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else{
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean isPalindrome(String word){
  return(word.equals(reverse(word)));
}
public String reverse(String str){
  String word="";
  for(int n=str.length();n>0;n--){word=word+str.substring(n-1,n);}
  return word;
}
public String lowercaseNoSpace(String str){
  String word="";
  for(int n=0;n<str.length();n++){
    if(Character.isLetter(str.charAt(n))) word=word+str.charAt(n);
  }
  return word.toLowerCase();
}
}
