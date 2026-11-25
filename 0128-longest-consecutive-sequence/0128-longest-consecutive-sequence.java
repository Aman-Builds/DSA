class Solution {
    // T(n) = O(n) 
    //S(n) = O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer>st = new HashSet<>() ; 
        int count = 0 ;
        for(int num : nums)
        {
            st.add(num) ;

        }
    int longest = 0 ;
    for(int num : st)
    {
        if(!st.contains(num-1)) // we do this to check this if this is the starting number
        {
           int currentNum = num ;
            count = 1 ;
        
         while(st.contains(currentNum+1)) // we do this to check consecutive numbers 
         {
            currentNum++ ;
            count++ ;
         }

         longest = Math.max(longest, count);

        }
    }
    return longest ;

    }
}