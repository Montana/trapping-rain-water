class Palindrome {
  // Should be something like O(n^2) O(n)
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n-i).equals(rev.substring(i))) 
                return rev.substring(0, i) + s;
        }
        return "";
    }
}

class Palindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        
        int i = 0;
        for (int j = n-1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) i++;
        }
        if (i == n) return s;
        
        String rev = new StringBuilder(s.substring(i)).reverse().toString();
        return rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
}
