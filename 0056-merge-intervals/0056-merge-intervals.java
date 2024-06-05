class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=r){
                r = Math.max(intervals[i][1],r);
            }
            else{
                ans.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        ans.add(new int[]{l,r});
        return ans.toArray(new int[ans.size()][]);
    }
}