package ec.nttdata.core.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

/**
 * Definición de la entidad implementando hibernate como ORM.
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */
@Data
@ToString
@MappedSuperclass
public class PersonsClients extends DateDB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOMBRE", unique = false)
	private String name;
	@Column(name = "GENERO", unique = false)
	private String gender;
	@Column(name = "EDAD", unique = false)
	private Integer age;
	@Column(name = "NUMERO_IDENTIFICACION", unique = true)
	private String identificationNumber;
	@Column(name = "DIRECCION", unique = false)
	private String address;
	@Column(name = "TELEFONO", unique = false)
	private String phone;
	
}
