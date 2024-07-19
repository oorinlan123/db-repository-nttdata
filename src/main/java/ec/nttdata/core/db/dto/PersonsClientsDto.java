package ec.nttdata.core.db.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonsClientsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String identificationNumber;
	private String name;
	private Integer age;
	private String address;
	private String phone;
	
}
