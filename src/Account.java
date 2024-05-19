abstract class Account {
    protected long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    public boolean transfer(Account account, long amount) {
        boolean success = false;

        // Проверяем, что списание средств прошло успешно
        if (pay(amount)) {
            // Если списание прошло успешно, то пытаемся зачислить средства на целевой счет
            if (account.add(amount)) {
                success = true;
            } else {
                // Если зачисление на целевой счет не удалось, возвращаем средства на исходный счет
                add(amount);
            }
        }

        return success;
    }

}
