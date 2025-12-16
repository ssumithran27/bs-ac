package bs.controller;
import bs.model.Beneficiary;
import bs.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiary")
public class BeneficiaryController {

        @Autowired
        private BeneficiaryService service;

        @PostMapping("/create")
        public Beneficiary create(@RequestBody Beneficiary beneficiary) {
            return service.create(beneficiary);
        }

     @GetMapping("/get")
     public ResponseEntity<List<Beneficiary>> getAll() {
        return ResponseEntity.ok(
                service.getAllBeneficiariesWithAccounts()
        );
    }
        @GetMapping("/get/{id}")
        public Beneficiary get(@PathVariable int id) {
            return service.get(id);
        }

        @PutMapping("/update/{id}")
        public String update(@PathVariable int id, @RequestBody Beneficiary beneficiary) {
            beneficiary.setBeneficiaryId(id);
            service.update(beneficiary);
            return "Updated successfully";
        }

        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable int id) {
            service.delete(id);
            return "Deleted successfully";
        }
    }


