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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.ForeignKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Definición de la entidad de cuentas implementando hibernate como ORM.
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = Accounts.TABLE_NAME, schema = Accounts.SCHEMA, indexes = {
		@Index(name = "USER_INDEX_ID_CUENTA", columnList = "ID_CUENTA")
})
@Entity
public class Accounts extends DateDB{

	protected static final String TABLE_NAME = "CUENTAS";
	protected static final String SEQUENCE = "SEQ_CUENTAS";
	protected static final String SCHEMA = "BANK_ACCOUNTS";
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1, schema = Accounts.SCHEMA)
	@Column(name = "ID_CUENTA")
	private Long accountId;
	
	@Column(name = "NUMERO_CUENTA", unique = false, length = 20)
	private String accountNumber;
	
	@Column(name = "TIPO_CUENTA", unique = false)
	private String accountType;
	
	@Column(name = "SALDO_INICIAL", unique = false)
	private Double initialBalance;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE",foreignKey = @ForeignKey(name = "FK_CLIENTE_CUENTA"), nullable = true)
	private Clients clientId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "accountId")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Movements> movementList;

}
