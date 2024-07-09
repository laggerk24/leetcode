class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0;
        double totalTime = 0;
        for(int[] customer:customers){
            if(customer[0] < totalTime){
                // System.out.print("If - ");
                totalTime += customer[1];
                waitingTime += totalTime-customer[0];
            }
            else{
                // System.out.print("else - ");
                totalTime = customer[0]+customer[1];
                waitingTime += customer[1];
            }
            // System.out.println("Total Time - " + totalTime+ " Waiting Time - "+waitingTime);
        }
        int n = customers.length;
        return waitingTime/n;
    }
}