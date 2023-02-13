import java.util.Arrays;

public class CoinChange {
    private static class Coin implements Comparable<Coin> {
        int denomination;
        int availableCoins;

        public Coin(int denomination, int availableCoins) {
            this.denomination = denomination;
            this.availableCoins = availableCoins;
        }

        public int compareTo(Coin o) {
            return Integer.compare(denomination, o.denomination);
        }
    }

 public static int[] minimumNumberOfCoins(int change, int[] denominations, int[] availableCoins) {
        int[] result = new int[denominations.length];
        Coin[] coins = new Coin[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            coins[i] = new Coin(denominations[i], availableCoins[i]);
        }
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i].denomination <= change && coins[i].availableCoins > 0) {
                int numOfCoins = change / coins[i].denomination;
                numOfCoins = Math.min(numOfCoins, coins[i].availableCoins);
                change -= numOfCoins * coins[i].denomination;
                coins[i].availableCoins -= numOfCoins;
                result[i] = numOfCoins;
            }
        }
 if (change == 0) {
            return result;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50};
        int[] availableCoins = {5, 10, 5, 10, 5, 2};
        int change = 43;
        int[] result = minimumNumberOfCoins(change, denominations, availableCoins);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println("Coins of denomination " + denominations[i] + ": " + result[i]);
            }
        } else {
            System.out.println("Change cannot be returned with the given denominations and available coins.");
        }
    }
}