class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        char[] S = s.toCharArray();
        int i = 0;

        for (char c : S)
            if ((c & 3) != 1)
                S[i++] = c;
            else if (i == 0 || ((c - S[--i] + 1) >> 1) != 1)
                return false;        

        return i == 0;
    }
}