package bs.repository;
import bs.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
      @Repository
      public class AccountsRepository {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        public void save(Accounts a) {
            String sql = """
            INSERT INTO account
            (beneficiary_id,nick_name,actual_name,actual_name_flag,ifsc,
             account_number,bank_name,daily_count,daily_limit,per_transaction_limit)
            VALUES (?,?,?,?,?,?,?,?,?,?)
            """;
            jdbcTemplate.update(sql,
                    a.getBeneficiaryId(),
                    a.getNickName(),
                    a.getActualName(),
                    a.getActualFlagName(),
                    a.getIfsc(),
                    a.getAccountNumber(),
                    a.getBankName(),
                    a.getDailyCount(),
                    a.getDailyLimit(),
                    a.getPerTransactionLimit()
            );
        }

          public List<Accounts> findByBeneficiaryMobile(String mobile) {

              String sql = """
            SELECT nick_name, actual_name, actual_name_flag,
                   ifsc, account_number, bank_name,
                   daily_count, daily_limit, per_transaction_limit
            FROM account a
            JOIN beneficiary b ON a.beneficiary_id = b.beneficiary_id
            WHERE b.mobile = ?
        """;

              return jdbcTemplate.query(sql, new Object[]{mobile}, (rs, rowNum) -> {
                  Accounts a = new Accounts();
                  a.setNickName(rs.getString("nick_name"));
                  a.setActualName(rs.getString("actual_name"));
                  a.setActualFlagName(rs.getString("actual_name_flag"));
                  a.setIfsc(rs.getString("ifsc"));
                  a.setAccountNumber(rs.getString("account_number"));
                  a.setBankName(rs.getString("bank_name"));
                  a.setDailyCount(rs.getInt("daily_count"));
                  a.setDailyLimit(rs.getDouble("daily_limit"));
                  a.setPerTransactionLimit(rs.getDouble("per_transaction_limit"));
                  return a;
              });
          }

        public List<Accounts> findByBeneficiaryId(int beneficiaryId) {
            String sql = "SELECT * FROM account WHERE beneficiary_id=?";
            return jdbcTemplate.query(sql, (rs, rn) -> {
                Accounts a = new Accounts();
                a.setAccountId(rs.getInt("account_id"));
                a.setBeneficiaryId(rs.getInt("beneficiary_id"));
                a.setNickName(rs.getString("nick_name"));
                a.setActualName(rs.getString("actual_name"));
                a.setActualFlagName(rs.getString("actual_name_flag"));
                a.setIfsc(rs.getString("ifsc"));
                a.setAccountNumber(rs.getString("account_number"));
                a.setBankName(rs.getString("bank_name"));
                a.setDailyCount(rs.getInt("daily_count"));
                a.setDailyLimit(rs.getDouble("daily_limit"));
                a.setPerTransactionLimit(rs.getDouble("per_transaction_limit"));
                return a;
            }, beneficiaryId);
        }

        public void deleteByBeneficiaryId(int beneficiaryId) {
            jdbcTemplate.update("DELETE FROM account WHERE beneficiary_id=?", beneficiaryId);
        }
    }







