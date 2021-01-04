package Practice;

public class Palindrome {
    public static int countPS(char[] str, int i, int j) {
        if(j<i)
            return 0;
        if (i == j)
            return 1;
        else {
            if (str[i]==str[j])
                return 1 + countPS(str, i + 1, j) + countPS(str, i, j - 1)-countPS(str, i+1,j-1);
            else
                return countPS(str, i + 1, j) + countPS(str, i, j - 1) - countPS(str, i + 1, j - 1);
        }
    }
}
