package ec.nttdata.core.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Definición de la entidad de personas implementando hibernate como ORM.
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = Movements.TABLE_NAME, schema = Movements.SCHEMA, indexes = {
		@Index(name = "USER_INDEX_ID_MOVIMIENTO", columnList = "ID_MOVIMIENTO")
})
@Entity
public class Movements extends DateDB{

	protected static final String TABLE_NAME = "MOVIMIENTOS";
	protected static final String SEQUENCE = "SEQ_MOVIMIENTOS";
	protected static final String SCHEMA = "BANK_ACCOUNTS";
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1, schema = Movements.SCHEMA)
	@Column(name = "ID_MOVIMIENTO")
	private Long movementId;
	
	@Column(name = "TIPO_MOVIMIENTO", unique = false)
	private String movementType;
	
	@Column(name = "VALOR", unique = false)
	private Double amount;
	
	@Column(name = "SALDO", unique = false)
	private Double balance;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CUENTA",foreignKey = @ForeignKey(name = "FK_CUENTA_MOVIMIENTO"), nullable = true)
	private Accounts accountId;

}
