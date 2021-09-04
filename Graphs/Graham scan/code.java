class Solution {
    
    public static double findSingleAngle(int[] p1,int[] p2){
        if(p2[1]==p1[1]){
            if(p2[0]-p1[0]>0)
                return(0);
            else if(p2[0]-p1[0]<0)
                return(180);
            else
                return(-1);
        }
        else{
            if(p1[0]==p2[0])
                return(90);
            else{
                double angle=Math.toDegrees(Math.atan((p2[1]-p1[1])/(float)(p2[0]-p1[0])));
                if(angle<0)
                    return(180+angle);
                else
                    return(angle);
            }
        }
    }
    
    public static int orientation(int[] p, int[] q, int[] r)
    {
        int val = (q[1] - p[1]) * (r[0] - q[0]) -
                  (q[0] - p[0]) * (r[1] - q[1]);

        if (val == 0) return 0;  // collinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }
    
    public int[][] outerTrees(int[][] trees) {
        if(trees.length<=3){
            return(trees);
        }
        int[] lowestPoint={200,200};
        int maxX=Integer.MIN_VALUE;
        int i,or;
        for(i=0;i<trees.length;i++){
            maxX=Math.max(maxX,trees[i][0]);
            if(lowestPoint[1]>trees[i][1]){
                lowestPoint[0]=trees[i][0];
                lowestPoint[1]=trees[i][1];
            }
            else if(lowestPoint[1]==trees[i][1]){
                if(lowestPoint[0]>trees[i][0]){
                    lowestPoint[0]=trees[i][0];
                    lowestPoint[1]=trees[i][1];
                }
            }
        }
        final int rightMostX=maxX;
        Arrays.sort(trees,new Comparator<int[]>(){
           public int compare(int[] e1,int[] e2){
               double a1=findSingleAngle(lowestPoint,e1);
               double a2=findSingleAngle(lowestPoint,e2);
               if(a1>a2)
                   return(1);
               else if(a1<a2)
                   return(-1);
               else{
                   if(e1[0]==e2[0]){
                       if(e1[0]==rightMostX){
                           if(e1[1]>e2[1])
                               return(1);
                           else
                               return(-1);
                       }
                       else{ 
                            if(e1[1]<e2[1])
                               return(1);
                           else
                               return(-1);
                       }
                   }    
                   else if(e1[0]>e2[0])
                        return(1);
                    else
                        return(-1);
               }
           } 
        });
        ArrayList<int[]> stack=new ArrayList<int[]>();
        stack.add(trees[0]);
        stack.add(trees[1]);
        for(i=2;i<trees.length;i++){
            or=orientation(stack.get(stack.size()-2),stack.get(stack.size()-1),trees[i]);
            while(or==1){
                stack.remove(stack.size()-1);
                or=orientation(stack.get(stack.size()-2),stack.get(stack.size()-1),trees[i]);
            }
            stack.add(trees[i]);
        }
        int[][] ans=new int[stack.size()][2];
        for(i=0;i<stack.size();i++)
            ans[i]=stack.get(i);
        return(ans);
    }
}
