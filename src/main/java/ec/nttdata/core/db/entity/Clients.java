package ec.nttdata.core.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Definición de la entidad de clientes implementando hibernate como ORM.
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = Clients.TABLE_NAME, schema = Clients.SCHEMA, indexes = {
		@Index(name = "USER_INDEX_ID_CLIENTE", columnList = "ID_CLIENTE")
})
@Entity
public class Clients extends PersonsClients{

	protected static final String TABLE_NAME = "CLIENTES";
	protected static final String SEQUENCE = "SEQ_CLIENTES";
	protected static final String SCHEMA = "USERS";
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1, schema = Clients.SCHEMA)
	@Column(name = "ID_CLIENTE")
	private Long clientId;
	
	@Column(name = "CONTRASENA", unique = false)
	private String pass;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "client")
	private Persons person;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "clientId")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Accounts> accountList;

}
