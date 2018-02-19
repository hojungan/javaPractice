public class PalindromeNumber {
    public static int reverseNum(int number) {
        String str = Integer.toString(number);
        String rev = new StringBuilder(str).reverse().toString();
        int num = Integer.parseInt(rev);
        return num;
    }

    public static boolean isPalindrome(int number){
        return number == reverseNum(number);
    }

    public static boolean isPrime(int number) {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                count++;
            }
        }
        if(count == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int size = 0, number = 2, width = 0, index = 1;

        while(size < 100) {

            if(isPrime(number) && isPalindrome(number)) {
                System.out.print(String.format("%3d", index)+"="+String.format("%05d", number)+" ");
                width++;
                index++;
                size++;
            }

            if(width == 10) {
                System.out.print("\n");
                width = 0;
            }
            number++;
        }
    }
}
