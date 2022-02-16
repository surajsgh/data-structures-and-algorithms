public class CheckIfTwoArraysAreEquals {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        int firstProduct = (int)A[0];
        int secondProduct = (int)B[0];

        if(A.length!=B.length) return false;

        for(int i=1; i<A.length; i++) {
            firstProduct ^= A[i];
        }

        for(int j=1; j<B.length; j++) {
            secondProduct ^= B[j];
        }

        int answer = firstProduct ^ secondProduct;

        if(answer==0) return true;
        else {
            return false;
        }
    }
}
