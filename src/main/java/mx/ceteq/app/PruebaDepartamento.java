package mx.ceteq.app;

import mx.ceteq.model.Departamento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PruebaDepartamento {

	public static void main(String[] args) {
		// Inicialización del runtime de Hibernate
				Configuration config = new Configuration().configure();
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
						.applySettings(config.getProperties())
						.buildServiceRegistry();

				// Obteniendo instancia  de SessionFactory
				SessionFactory sessionFactory;
				sessionFactory = config.buildSessionFactory(serviceRegistry);
		
				// Obtener uns instancia de Session usuando SesionFactory
				Session session = sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
				Departamento d1 = new Departamento();
				d1.setId(10);
				d1.setNombre("Produccion");
				session.save(d1);
				tx.commit();
				System.out.println("Programa Terminado...");
				
				
	}
}