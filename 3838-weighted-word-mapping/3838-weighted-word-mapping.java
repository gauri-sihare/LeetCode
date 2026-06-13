class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            long sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            int mod = (int)(sum % 26);
            result.append((char)('z' - mod));
        }

        return result.toString();
    }
}