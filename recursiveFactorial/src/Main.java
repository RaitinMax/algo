public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int n = 5;
        main.factorial(n);
        System.out.println(n);
    }
    private void  factorial(int n) {
        int result = 1;

//        if (n == 0) {
//            System.out.print(" = ");
//            return result;
//        }
        if (n == 1) {
//            System.out.print(" * 1 = ");
            return ;
        }

        System.out.print(n);
//        if (n != 2) {
//            System.out.print(" * ");
//        }
        factorial(factorial(n-1)*factorial(n));
//        factorial(n-1);{}
        return ;
    }



}
