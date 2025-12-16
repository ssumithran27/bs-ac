package bs.model;

public class Accounts {
    private int accountId;
    private int beneficiaryId;
    private String nickName;
    private String actualName;
    private String actualFlagName;
    private String ifsc;
    private String accountNumber;
    private String bankName;
    private int dailyCount;
    private double dailyLimit;
    private double perTransactionLimit;

    public Accounts() {
        this.accountId = accountId;
        this.beneficiaryId = beneficiaryId;
        this.nickName = nickName;
        this.actualName = actualName;
        this.actualFlagName = actualFlagName;
        this.ifsc = ifsc;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.dailyCount = dailyCount;
        this.dailyLimit = dailyLimit;
        this.perTransactionLimit = perTransactionLimit;
    }


    public double getPerTransactionLimit() {
        return perTransactionLimit;
    }

    public void setPerTransactionLimit(double perTransactionLimit) {
        this.perTransactionLimit = perTransactionLimit;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public int getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(int dailyCount) {
        this.dailyCount = dailyCount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getActualFlagName() {
        return actualFlagName;
    }

    public void setActualFlagName(String actualFlagName) {
        this.actualFlagName = actualFlagName;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
