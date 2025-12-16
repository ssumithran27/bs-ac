package bs.model;
import java.util.List;

public class Beneficiary {
private int beneficiaryId;
private String name;
private String mobile;
private String email;
private String type;
private List<Accounts> accounts;

    public Beneficiary(int beneficiaryId, String name, String mobile, String email, String type, List<Accounts> accounts)
    {
      this.beneficiaryId=beneficiaryId;
      this.name=name;
      this.mobile=mobile;
      this.email=email;
      this.type=type;
      this.accounts=accounts;
    }

    public Beneficiary() {

    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}
