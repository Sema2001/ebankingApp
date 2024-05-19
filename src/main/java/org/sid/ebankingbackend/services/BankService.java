package org.sid.ebankingbackend.services;

import jakarta.transaction.Transactional;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("2c60894b-6c44-4a5a-95da-059d44f2e51a").orElse(null);
        if(bankAccount != null){
            if(bankAccount != null){
                System.out.println("--------------------------------------------------------------");
                System.out.println(bankAccount.getId());
                System.out.println(bankAccount.getBalance());
                System.out.println(bankAccount.getStatus());
                System.out.println(bankAccount.getCreatedAt());
                System.out.println(bankAccount.getCustomer().getName());
                System.out.println(bankAccount.getClass().getSimpleName());
                if (bankAccount instanceof CurrentAccount){
                    System.out.println("Over Draft "+ ((CurrentAccount) bankAccount).getOverDraft());
                } else if (bankAccount instanceof SavingAccount){
                    System.out.println("Interest rate "+ ((SavingAccount) bankAccount).getInterestRate());
                }
                bankAccount.getAccountOperations().forEach(accountOperation -> {
                    System.out.println(accountOperation.getType() + "\t"
                            + accountOperation.getOperationDate() +"\t"+accountOperation.getAmount());
                });





            }

        }
    }

}
