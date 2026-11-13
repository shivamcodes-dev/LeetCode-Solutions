class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findTargetSum(candidates, target, 0, curr, ans);
        return ans; 
    }

    public void findTargetSum(int[] arr, int target, int i, List<Integer> curr, List<List<Integer>> ans){
        if(target < 0|| i == arr.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        
        curr.add(arr[i]);
        findTargetSum(arr, target - arr[i], i, curr, ans);
        
        // curr.add(arr[i]);
        // findTargetSum(arr, target - arr[i], i+1, curr, ans);

        curr.remove(curr.size()-1); //kyu ki jo extra element add huaa tha usko base hit hone ke baad remove hi nhi kiye the
        findTargetSum(arr, target, i+1, curr, ans);

    }
}