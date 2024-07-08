public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(15000);

        while (true) {
            try {
                bankAccount.withdraw(6000);
                System.out.println("С вашего счета была снято сумма на " + bankAccount.getAmount());
            } catch (LimitException e) {
                System.out.println("На вашем счету не достаточно средств " + e.getRemainingAmount());
                System.out.println("С вашего счета была снято остаток суммы " + e.getRemainingAmount());
                try {
                    bankAccount.withdraw((int) e.getRemainingAmount());
                } catch (LimitException exception) {

                }
                break;
            }

        }
    }
}