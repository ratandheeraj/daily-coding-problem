// Question:
// Given a dictionary of words and a string made up of those words (no spaces), return the original 
// sentence in a list. If there is more than one possible reconstruction, return any of them. If there 
// is no possible reconstruction, then return null.

// For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", 
// you should return ['the', 'quick', 'brown', 'fox'].

// Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
// return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

// Answer:
// Using brute force approach:
// We will try to contruct every word from the sentence, and check if it exists in the dictionary.
// If yes, then we will add the word into the answer list, else we will continue to search for word.

// We will return the list as answer, if size is less than 1, then we will return none.


import java.util.ArrayList;

public class Day22{
    public static ArrayList<String> findOriginalSentence(String[] dict, String sentence){
        String s = "";
        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i < sentence.length();i++){
            s = s + sentence.charAt(i);
            for(String str:dict){
                if(s.equals(str)){
                    ans.add(s);
                    s = "";
                }
            }
        }
        
        if(ans.size() == 0){
            return null;
        }
        return ans;
    }

    public static void main(String[] args){
        String[] dict = {"quick", "brown", "the", "fox"};
        String sentence = "thequickbrownfox";
        ArrayList<String> ans = findOriginalSentence(dict,sentence);
        System.out.println(ans);
    }
}


// Time Complexity: O(n!) {Worst case if word is not found}
// Space Complexity: O(n)