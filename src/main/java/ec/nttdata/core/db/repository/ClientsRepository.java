package ec.nttdata.core.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.nttdata.core.db.entity.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long>{

	public Clients findByCode(String code);
	public Clients findByCodeAndStatus(String code, String status);
	
	public Clients findByIdentificationNumber(String identificationNumber);
	public Clients findByIdentificationNumberAndStatus(String code, String identificationNumber);

}
