package CodeReview.SRP;

public class ContaImprove {

    public class Account {
        private String identify;
        private double balance;

        public Account(String identify, double balance) {
            this.identify = identify;
            this.balance = balance;
        }
    }

    public class Transaction {
        private Account account;
        private double amount;

        public Transaction(Account account, double amount) {
            this.account = account;
            this.amount = amount;
        }

        public void withDraw(Account account, double amount) {
            account.balance += amount;
        }

        public void deposite(Account account, double amount) {
            account.balance -= amount;
        }
    }
}
