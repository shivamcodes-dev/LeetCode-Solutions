class Solution {
    public int majorityElement(int[] nums) {
        // int frq = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }
        Set<Integer> keySet = hm.keySet();
        for(Integer ele: keySet){
            if(hm.get(ele) > nums.length/2){
                return ele;
            }
        }
        return -1;
    }
}