package factory;

public class CoinFactory extends Factory{
    public static CoinFactory newInstance()
    {
        return new CoinFactory();
    }

    public static CoinProvider getCoin(String bank){
        if(bank.equals("abc")) return new AbcCoin();
        throw new InvalidBankException("Invalid Bank");
    }
}
