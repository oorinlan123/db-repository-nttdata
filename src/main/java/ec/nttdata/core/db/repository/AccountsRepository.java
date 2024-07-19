package ec.nttdata.core.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.nttdata.core.db.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long>{

	public Accounts findByCode(String code);
	public Accounts findByCodeAndStatus(String code, String status);
	public Accounts findByAccountNumber(String accountNumber);
	public Accounts findByAccountNumberAndStatus(String accountNumber, String status);
}
