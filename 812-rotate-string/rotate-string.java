class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() !=  goal.length()){
            return false;
        }

        String joint = goal+goal;
        
        if(joint.contains(s)){
            return true;
        }else{
            return false;
        }
    }
}