package mx.ceteq.banco.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	@Id
	@Column(name = "NUMERO")
	private String numero;
	
	@Temporal (TemporalType.DATE)
	@Column (name = "FECHA_APERTURA")
	private Date fechaApertura;
	
	@Enumerated (EnumType.ORDINAL) 
	@Column (name = "TIPO")
	private TipoCuenta tipo;
	
	@Column (name = "SALDO")
	private BigDecimal saldo;
	
	@Transient 
	private Integer antiguedad;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public TipoCuenta getTipo() {
		return tipo;
	}

	public void setTipo(TipoCuenta tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}
	
}
