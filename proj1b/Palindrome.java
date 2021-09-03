import org.junit.Test;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
    Deque<Character> a=new LinkedListDeque<>();
    char[] strCharArray = word.toCharArray();
    int length=strCharArray.length;
        for (int i = 0; i < length; i++) {
            a.addLast(word.charAt(i));
        }
    return a;
    }


    public boolean isPalindrome(String word){
    Deque<Character> a=wordToDeque(word);
    int length=a.size();
    Deque<Character> b=new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            b.addFirst(a.get(i));
        }
        for (int i = 0; i < length; i++) {
            if(!a.get(i).equals(b.get(i))){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> a=wordToDeque(word);
        int length=a.size();
        Deque<Character> b=new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            b.addFirst(a.get(i));
        }
        if(length%2==0) {
            for (int i = 0; i < length; i++) {
                if (!cc.equalChars(a.get(i), b.get(i))) {
                    return false;
                }
            }
            return true;
        }
        else{
            for (int i = 0; i < length&&i!=length/2; i++) {
                if (!cc.equalChars(a.get(i), b.get(i))) {
                    return false;
                }
            }
            return true;
        }

    }
}
