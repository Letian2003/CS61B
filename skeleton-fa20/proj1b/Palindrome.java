public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d=new LinkedListDeque<Character>();
        for(int i=0;i<word.length();i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }
    public boolean isPalindrome(String word){
        if(word==null)
            return false;
        int len = word.length();
        for(int i=0;i<len/2;i++){
            if(word.charAt(i) != word.charAt(len-i-1))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        
    }
}
