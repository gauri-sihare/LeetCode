class Solution {
    public boolean checkIfExist(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele : arr){
            hm.put( ele, hm.getOrDefault(ele, 0) +1);
        }
        
        
        for(int i= 0 ; i< arr.length ;i++){
            if(arr[i] == 0){
                if(hm.get(0) >=2 ){
                    return true;
                }
            }
            else if(hm.containsKey(arr[i]*2)){
                return true;
            }
            else if(arr[i] %2 ==0 && hm.containsKey( arr[i]/2 )){
                return true;
            }
        }
    return false;
    }
}