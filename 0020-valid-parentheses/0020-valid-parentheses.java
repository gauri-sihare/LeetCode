class Solution {
    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                str.push(')');
            }
            else if(ch == '{'){
                str.push('}');
            }
            else if(ch=='['){
                str.push(']');
            }
            else if(str.isEmpty() || str.pop()!= ch){
                return false;
            }
        }
        return str.isEmpty();
    }
}