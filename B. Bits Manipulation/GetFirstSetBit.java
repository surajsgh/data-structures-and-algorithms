class GetFirstSetBit {
    public static void main(String[] args) {
        System.out.println(getFirstSetBitPos(18));
        System.out.println(getFirstSetBitPosNaive(12));
    }

    public static int getFirstSetBitPosNaive(int number) {
         int count = 1;

         if((n&1)==1) {
             return 1;
         }

         while((n&1)!=1) {
             n=n>>1;
             ++count;
         }
         return count;
    }

    public static int getFirstSetBitPos(int number) {
        if (number==0) {
            return 0;
        }

        int position = 1;

        while(number>0) {
            if (number&1==1) {
                break;
            }
            else {
                number=number>>1;
                position++;
            }
        }

        return position;
    }
}