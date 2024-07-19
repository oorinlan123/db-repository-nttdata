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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

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
@Table(name = Persons.TABLE_NAME, schema = Persons.SCHEMA, indexes = {
		@Index(name = "USER_INDEX_ID_PERSONA", columnList = "ID_PERSONA")
})
@Entity
public class Persons extends PersonsClients{

	protected static final String TABLE_NAME = "PERSONAS";
	protected static final String SEQUENCE = "SEQ_PERSONAS";
	protected static final String SCHEMA = "USERS";
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1, schema = Persons.SCHEMA)
	@Column(name = "ID_PERSONA")
	private Long personId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID", foreignKey = @ForeignKey(name = "FK_PERSONA_CLIENTE"),  nullable = true)
	private Clients client;

}
