class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } 
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } 
            else { // '*'
                minOpen--; // '*' acts as ')'
                maxOpen++; // '*' acts as '('
            }

            // Too many ')' even if '*' are used optimally
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative
            minOpen = Math.max(minOpen, 0);
        }

        // If there can be a valid assignment with 0 unmatched '('
        return minOpen == 0;
    }
}