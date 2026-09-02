class Solution {

    Boolean[][] dp;

    public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length()][p.length()];

        return solve(s.length() - 1, p.length() - 1, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {

        // Both string and pattern are finished
        if (i < 0 && j < 0)
            return true;

        // Pattern finished but string still remains
        if (i >= 0 && j < 0)
            return false;

        // String finished but pattern remains
        if (i < 0 && j >= 0)
            return isAllStars(p, j);

        // If already calculated
        if (dp[i][j] != null)
            return dp[i][j];

        // Characters match or pattern contains ?
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {

            return dp[i][j] =
                    solve(i - 1, j - 1, s, p);
        }

        // Pattern contains *
        if (p.charAt(j) == '*') {

            return dp[i][j] =
                    solve(i - 1, j, s, p) ||
                    solve(i, j - 1, s, p);
        }

        return dp[i][j] = false;
    }

    private boolean isAllStars(String p, int j) {

        for (int k = 0; k <= j; k++) {

            if (p.charAt(k) != '*')
                return false;
        }

        return true;
    }
}