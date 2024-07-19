package ec.nttdata.core.db.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto extends PersonsClientsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String accountNumber;
	private String accountType;
	private String initialBalance;
	private List<MovementsDto> movementList;
	
}
