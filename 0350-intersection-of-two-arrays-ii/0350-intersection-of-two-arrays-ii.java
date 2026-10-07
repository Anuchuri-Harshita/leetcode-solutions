class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Store frequency of nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Find intersection
        for (int num : nums2) {

            if (freq.getOrDefault(num, 0) > 0) {

                result.add(num);

                // Use one occurrence
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}