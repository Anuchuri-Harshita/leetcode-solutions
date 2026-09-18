class Solution {
    public int countSegments(String s) {
    int t=0;
    int c=0;
    int n=s.length();
    for(int i=0;i<n;i++){
        if(s.charAt(i)!=' '&&t==0){
            c++;
            t=1;
        }
        if(s.charAt(i)==' ') t=0;
    
    }
    return c;
    }
}