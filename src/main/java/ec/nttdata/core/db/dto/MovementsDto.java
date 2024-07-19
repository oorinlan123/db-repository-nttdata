package ec.nttdata.core.db.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementsDto extends PersonsClientsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String movementType;
	private Double amount;
	private Double balance;
	
}
