class CreditAccount extends Account {
    private final long creditLimit;

    public CreditAccount(long balance, long creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0 && balance + amount <= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        if (amount > 0 && Math.abs(balance) + amount <= Math.abs(creditLimit)) {
            balance -= amount;
            return true;
        }
        return false;
    }
}