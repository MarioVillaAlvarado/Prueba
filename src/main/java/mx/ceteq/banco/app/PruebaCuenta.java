package mx.ceteq.banco.app;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mx.ceteq.banco.model.Cuenta;
import mx.ceteq.banco.model.TipoCuenta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PruebaCuenta {

	public static void main(String[] args) throws ParseException {
		// Inicialización del runtime de Hibernate
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// Obteniendo instancia de SessionFactory
		SessionFactory sessionFactory; 
		sessionFactory = config.buildSessionFactory(serviceRegistry);

		// Obtener uns instancia de Session usuando SesionFactory
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Cuenta c1 = new Cuenta();
		//internacionalizacion 
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL,new Locale("es"));
		System.out.println(df1.format(new Date()));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// froma basica de manejo de fechas 
		System.out.println(df.format(new Date()));
		Date d1 = df.parse("21/06/1988");
		
		c1.setFechaApertura(d1);
		c1.setNumero("00005");
		c1.setSaldo(new BigDecimal("1250.99"));
		c1.setTipo(TipoCuenta.CHEQUES);
		
		session.save(c1);
		
		//buscar una cuenta, y modificarla
		Cuenta c2 = (Cuenta)session.get(Cuenta.class, "002");
		BigDecimal interes = new BigDecimal(1.10);
		BigDecimal nuevoSaldo = c2.getSaldo().multiply(interes);
		c2.setSaldo(nuevoSaldo);
		session.update(c2);
		
		tx.commit();
		System.out.println("Programa Terminado");

	}

}
