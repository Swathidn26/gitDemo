package string;

public class SmallestandLongestword {

	public static void main(String[] args) {
		String string = "Rahul Shetty Academy is the best";

        String[] words = string.trim().replaceAll("\\s+", " ").split(" ");
        for(int i =0;i<words.length;i++) {
        
        System.out.println(words[i]);
        }

           String shortest = words[0];

           String longest =  words[0];

           for(String word : words){

             if(word.length() < shortest.length()){

                   shortest = word;

               }

             if(word.length() > longest.length()){

                   longest = word;

               }

           }

           System.out.println("The Shortest Word = "+shortest);  

           System.out.println("The Longest Word = "+ longest);

   } 

}