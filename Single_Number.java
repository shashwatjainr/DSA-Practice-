class Solution {

    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null; // Value not found
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> dup= new HashMap<>();
        
        for(int i=0; i <nums.length; i++){
            if(dup.containsKey(nums[i])){
                dup.put(nums[i], 2);
            }
            else{
                dup.put(nums[i], 1);
            }
        }
        return getKeyByValue(dup, 1);
    }
}

//I submitted the above solution

//Using XOR is a better aproach
//Using property of XOR that a^a=0 and a^0=a
//Take xor of each number with another number.