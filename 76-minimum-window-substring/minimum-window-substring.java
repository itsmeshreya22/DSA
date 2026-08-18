class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] freq = new int[128];

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int left = 0;
        int right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            // Character is needed
            if (freq[r] > 0) {
                required--;
            }
            freq[r]--;
            right++;

            // Current window contains all characters of t
            while (required == 0) {

                // Update minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Remove left character
                char l = s.charAt(left);
                freq[l]++;

                // Now a required character is missing
                if (freq[l] > 0) {
                    required++;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}