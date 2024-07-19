package ec.nttdata.core.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.nttdata.core.db.entity.Movements;
import ec.nttdata.core.db.entity.Persons;

public interface MovementsRepository extends JpaRepository<Movements, Long>{

	public List<Movements> findByCode(String code);
	public List<Movements> findByCodeAndStatus(String code, String status);
	
	public List<Movements> findByMovementType(String movementType);
	public List<Movements> findByMovementTypeAndStatus(String movementType, String status);
	

	
}
