package bs.service;
import bs.model.Accounts;
import bs.model.Beneficiary;
import bs.repository.AccountsRepository;
import bs.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeneficiaryService {
        @Autowired
        private BeneficiaryRepository beneficiaryRepo;
        @Autowired
        private AccountsRepository accountsRepository;

        public Beneficiary create(Beneficiary beneficiary) {
            int beneficiaryId = beneficiaryRepo.save(beneficiary);

            for (Accounts account : beneficiary.getAccounts()) {
                account.setBeneficiaryId(beneficiaryId);
                accountsRepository.save(account);
            }
            return beneficiary;
        }

    public List<Beneficiary> getAllBeneficiariesWithAccounts() {

        List<Beneficiary> beneficiaries = beneficiaryRepo.findAll();

        for (Beneficiary b : beneficiaries) {
            List<Accounts> accounts =
                    accountsRepository.findByBeneficiaryMobile(b.getMobile());
            b.setAccounts(accounts);
        }

        return beneficiaries;
    }
        public Beneficiary get(int id) {
            Beneficiary b = beneficiaryRepo.findById(id);
            b.setAccounts(accountsRepository.findByBeneficiaryId(id));
            return b;
        }

        public void update(Beneficiary beneficiary) {
            beneficiaryRepo.update(beneficiary);
            accountsRepository.deleteByBeneficiaryId(beneficiary.getBeneficiaryId());

            for (Accounts acc : beneficiary.getAccounts()) {
                acc.setBeneficiaryId(beneficiary.getBeneficiaryId());
                accountsRepository.save(acc);
            }
        }

        public void delete(int id) {
            accountsRepository.deleteByBeneficiaryId(id);
            beneficiaryRepo.delete(id);
        }
    }


