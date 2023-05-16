package bank.application;

public interface BankInterface {
    // interface is the definition part
    //these are just the functions that we need to have
    public int checkBalance(String password);

    public String addMoney(int money);

    public String withdrawMoney(int money, String password);

    public String changePassword(String oldPassword, String newPassword);

    public double calculateTotalInterest(int years);

    /*
            //TODO we will try to trasfer money within the same bank
            Transfer money

            within the same bank
     */
}
