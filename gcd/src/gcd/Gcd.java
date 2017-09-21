package gcd;

public class Gcd {
    final static int LENGTH = 20;
    
    public static void main(String[] args) {
        int result = gcdEucledian(693, 854);
        System.out.println("Eucledian: " + result);
        gcdPrimeFactors(693, 854);
        
        result = gcdEucledian(867, 1989);
        System.out.println("Eucledian: " + result);
        gcdPrimeFactors(867, 1989);
        
        result = gcdEucledian(1854, 1293);
        System.out.println("Eucledian: " + result);
        gcdPrimeFactors(1854, 1293);
    }
    
    private static void gcdPrimeFactors(int a, int b){
        int[] factors = new int[20];
        int[] temp = new int[20];
        int index;
        int number;
        for(int i = 1; i < 3; i++){
            if(i == 1){
                number = a;
            }
            else{
                temp = factors;
                number = b;
            }
            factors = new int[LENGTH];
            index = 0;
            for(int j = 2; number > 1 && j < 100; j++){
                if(isPrime(j) == true){
                    if(number % j == 0){
                        factors[index++] = j;
                        number /= j;
                        j = 1;
                    }
                }
            }   
        }
        int[] numbers;
        numbers = new int[LENGTH];
        index = 0;
        for(int k = 0; temp[k] != 0 && k < LENGTH; k++){
            if(isAvailable(temp[k], factors) == true){
                numbers[index++] = temp[k];
            }
        }
        int result = 1;
        for(int l = 0; l < index; l++){
            result *= numbers[l];
        }
        System.out.println("Primfaktorenzerlegung: " + result);
    }
    
    private static boolean isAvailable(int number, int[] array){
        for(int i = 0; array[i] != 0 && i < LENGTH; i++){
            if(array[i] == number){
                array[i] = -1;
                return true;
            }
        }
        return false;
    }
    
    private static int gcdEucledian(int a, int b){
        if(b == 0){
            return a;
        }
        return gcdEucledian(b, a % b);
    }
    
    private static boolean isPrime(int number){
        for(int i = 2; i < number && i < 100; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}