public class SquareRoot {
    public static void main(String[] args) {
//        System.out.println(findSquareRootNaive(37));
        System.out.println(findSquareRootEfficient(26));
    }

//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int findSquareRootEfficient(int number) {
        long low = 1;
        long high = number;
        long result = -1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sqr = mid*mid;
            if (sqr == number) {
                return (int)mid;
            }
            else if (sqr > number) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
                result = mid;
            }
        }
        return (int)result;
    }

//    Time Complexity : O(sqrt(n))
//    Auxiliary Space : O(1)
    public static int findSquareRootNaive(int number) {
        long i=1;
        while (i*i <= number) {
            i++;
        }
        return (int)i-1;
    }
}
