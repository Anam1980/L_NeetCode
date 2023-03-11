class Solution {
    public boolean isPalindrome(int x) {
        int N=x;

        int temp=0;
        while(x>0){
            temp = temp*10 + x%10;
            x=x/10;
        }

        if(temp==N)return true;

        return false;
    }
}//0*10+1=1
//1*10+2=12
