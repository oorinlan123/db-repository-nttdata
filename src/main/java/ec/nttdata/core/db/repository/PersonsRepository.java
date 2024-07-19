package ec.nttdata.core.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.nttdata.core.db.entity.Clients;
import ec.nttdata.core.db.entity.Persons;

public interface PersonsRepository extends JpaRepository<Persons, Long>{

	public Persons findByCode(String code);
	public Persons findByCodeAndStatus(String code, String status);
	
	public Persons findByIdentificationNumber(String identificationNumber);
	public Persons findByIdentificationNumberAndStatus(String code, String identificationNumber);

}
