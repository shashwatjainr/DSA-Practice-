class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        HashSet<Integer> numbers= new HashSet<>();
        for(int i=0; i<n; i++){
            numbers.add(nums[i]);
        }
        int j=0;
        for(j=0; j <n; j++){
            if(!numbers.contains(j)){
                break;
            }
        }
        return j;
    }
}

// Above is my submitted code

// Better Approach is to add all elements of Arrays 
// and submit this sum from sum of (nums.legth) consequtive numbers.
