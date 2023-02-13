import java.util.Scanner;

public class SpellOut {
    static String basic[] = { "", "one", "two", "three", "four",
                     "five", "six", "seven", "eight",
                     "nine", "ten", "eleven", "twelve",
                     "thirteen", "fourteen", "fifteen",
                     "sixteen", "seventeen", "eighteen",
                     "nineteen"};
    
    static String tens[] = { "", "", "twenty", "thirty", "forty",
                     "fifty", "sixty", "seventy", "eighty",
                     "ninety" };
    
    static String spellOut(int x) {
        if (x<20) {
            // Basic cases.
            return basic[x];
        }
        else if (x<100) {
            // Cases less than 100 (2 digit).
            return tens[x/10] + "-" + basic[x%10];
        } else if (x<1000) {
            // Cases between 100 to 999.
            return spellOut(x/100) + " hundred " + spellOut(x%100);
        } else if (x%1000<100) {
            // Cases like 1003, 2047 etc.
            return spellOut(x/1000) + " thousand " + spellOut(x%100);
        } else {
            // Cases like 5300, 4756 etc.
            return spellOut(x/100) + " hundred " + spellOut(x%100);
        }
    }
   public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, a;
        n = sc.nextInt();
        
        for(int i=0;i<n;i++) {
            a = sc.nextInt();
            System.out.println(spellOut(a));
        }
   }
}