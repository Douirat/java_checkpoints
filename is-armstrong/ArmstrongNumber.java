public class ArmstrongNumber {
    public boolean isArmstrong(int number) {
        int total = 0, n = number;
        while(n !=0){
            total++;
            n /=10;
        }
        int sum = 0;
        n = number;
        while(n != 0){
            int temp = n%10;
            sum += Math.pow(temp, total);
            n/=10;
        }
        return sum == number;
    }
}