public class Player {
    private   Integer startingAccountBalance;
    private String playerName;

    public Player(String playerName, int startingAccountBalance)
    {
        this.playerName = playerName;
        this.startingAccountBalance = startingAccountBalance;
    }

    public void subtract(int subtractBet)
    {
        startingAccountBalance -= subtractBet;
    }

    public void add(int addBet) {
        startingAccountBalance += addBet;
    }

    public String print() {
        return playerName + " have $" + startingAccountBalance + " in your account.";
    }
}
