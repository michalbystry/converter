package pl.michal.Sorting;

/**
 * Created by Michał on 2015-02-22.
 */
public class Silnia {

    public int countFactorialRec (int x){
        if(x==0){
            return 1;
        }
        else {
           return x*countFactorialRec(x-1);
        }
    }
    public int countFactorialLoop (int i){
int result=1;
        while(i>1){
        result*=i;
            i--;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
Silnia silnia = new Silnia();
//        System.out.println(silnia.countFactorialRec(5));
        System.out.println(silnia.countFactorialLoop(5));
    }

}
