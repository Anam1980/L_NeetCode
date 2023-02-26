/*Given two binary strings a and b, return their sum as a binary string.*/


class Solution {
    public String addBinary(String a, String b) {
        
        int i=a.length()-1;
        int j=b.length()-1;

        StringBuilder sb=new StringBuilder();

        int carry=0;
        
        while(i>=0 || j>=0){

            //take carry and sum equal
            int sum = carry;

            //add both ch from last 
             if(j>=0){
                sum += b.charAt(j)-'0';
                j--;
            }

             if(i>=0){
                sum += a.charAt(i)-'0';
                i--;
            }
            //add to string
            sb.append(sum%2);

            //take carry
            carry = sum/2;    
        }

        //add remaining carry
        if(carry>0){
            sb.append(carry);
        }

        //reverse it and return
        return sb.reverse().toString();
    }
}
