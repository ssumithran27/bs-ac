package bs.repository;
import bs.model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BeneficiaryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(Beneficiary b) {
        String sql = "INSERT INTO beneficiary(name,mobile,email,type) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, b.getName(), b.getMobile(), b.getEmail(), b.getType());

        return jdbcTemplate.queryForObject(
                "SELECT LAST_INSERT_ID()", Integer.class
        );
    }

    public List<Beneficiary> findAll() {

        String sql = """
            SELECT beneficiary_id, name, mobile, email, type
            FROM beneficiary
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Beneficiary b = new Beneficiary();
            b.setName(rs.getString("name"));
            b.setMobile(rs.getString("mobile"));
            b.setEmail(rs.getString("email"));
            b.setType(rs.getString("type"));
            return b;
        });
    }


    public Beneficiary findById(int id) {
        String sql = "SELECT * FROM beneficiary WHERE beneficiary_id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rn) -> {
            Beneficiary b = new Beneficiary();
            b.setBeneficiaryId(rs.getInt("beneficiary_id"));
            b.setName(rs.getString("name"));
            b.setMobile(rs.getString("mobile"));
            b.setEmail(rs.getString("email"));
            b.setType(rs.getString("type"));
            return b;
        }, id);
    }

    public void update(Beneficiary b) {
        String sql = "UPDATE beneficiary SET name=?,mobile=?,email=?,type=? WHERE beneficiary_id=?";
        jdbcTemplate.update(sql,
                b.getName(), b.getMobile(), b.getEmail(), b.getType(), b.getBeneficiaryId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM beneficiary WHERE beneficiary_id=?", id);
    }
}





