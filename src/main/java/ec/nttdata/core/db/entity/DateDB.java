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
public class DateDB implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name = "CODIGO", unique = true, length = 100)
	private String code;
	@Column(name = "ESTADO", unique = false, length = 100)
	private String status;
	@Column(name = "USUARIO_CREACION", unique = false, length = 100)
	private String createUser;
	@Column(name = "USUARIO_MODIFICACION", unique = false, length = 100)
	private String modifyUser;
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}
