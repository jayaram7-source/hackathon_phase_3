class bankledger {
    String name;
    long accNo;
    double balance;
    double initialBalance;
    double totalDeposits = 0;
    double totalWithdrawals = 0;

    // Constructor with initial balance
    bankledger(String name, long accNo, double balance) {
        this.name = name.trim().toUpperCase();
        this.accNo = accNo;
        this.balance = balance;
        this.initialBalance = balance;
    }

    bankledger(String name, long accNo) {
        this(name, accNo, 0);
    }

    // Overloaded deposit
    void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
        System.out.println("Deposit Amount      : Rs. " + amount);
        System.out.println("Transaction Status  : Deposit Successful");
        System.out.println("Updated Balance     : Rs. " + balance);
        System.out.println();
    }

    void deposit(double amount, String note) {
        System.out.println("Note                : " + note);
        deposit(amount);
    }

    // Overloaded withdraw
    void withdraw(double amount) {
        System.out.println("Withdrawal Amount   : Rs. " + amount);
        if (amount > balance) {
            System.out.println("Transaction Status  : Insufficient Balance");
            System.out.println("Available Balance   : Rs. " + balance);
        } else {
            balance -= amount;
            totalWithdrawals += amount;
            System.out.println("Transaction Status  : Withdrawal Successful");
            System.out.println("Updated Balance     : Rs. " + balance);
        }
        System.out.println();
    }

    void withdraw(double amount, String note) {
        System.out.println("Note                : " + note);
        withdraw(amount);
    }

    public static void main(String[] args) {
        bankledger acc = new bankledger("  Ravi Kumar ", 1234567890L, 10000);

        System.out.println("========== PERSONAL BANKING LEDGER ==========");
        System.out.println("Account Holder Name : " + acc.name);
        System.out.println("Account Number      : " + acc.accNo);
        System.out.println("Initial Balance     : Rs. " + acc.initialBalance);
        System.out.println();
        System.out.println("---------- TRANSACTION DETAILS ----------");

        acc.deposit(5000);
        acc.withdraw(2000);
        acc.withdraw(20000, "Large withdrawal");

        System.out.println("---------- ACCOUNT SUMMARY ----------");
        System.out.println("Account Holder      : " + acc.name);
        System.out.println("Account Number      : " + acc.accNo);
        System.out.println("Total Deposits      : Rs. " + acc.totalDeposits);
        System.out.println("Total Withdrawals   : Rs. " + acc.totalWithdrawals);
        System.out.println("Final Balance       : Rs. " + acc.balance);
        System.out.println();

        if (acc.name.equalsIgnoreCase("ravi kumar")) {
            System.out.println("Account Holder Verification: Names Match");
        } else {
            System.out.println("Account Holder Verification: Names Do Not Match");
        }
        System.out.println("=============================================");
    }
}