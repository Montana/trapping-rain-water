class ArrayScrabble {
public:
    bool solve(vector<int>& nums, int mid, int m) {
        int total = 0;
        int subArrays = 0;
        int n = nums.size();
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > mid)
                return false;
            
            if(total + nums[i] <= mid)
                total += nums[i];
            else {
                subArrays++;
                total = nums[i];
            }
        }
        subArrays++;
        
        return (subArrays <= m);
    }
    
    int splitArray(vector<int>& nums, int m) {
        int n = nums.size();
        
        int l = 0;
        int r = (int)(1e9 + 1);
        
        while(l < r) {
            int mid = (r + l)/2;
            if(solve(nums, mid, m))
                r = mid;
            else
                l = mid + 1;
        }
        
        return l;
    }
};
