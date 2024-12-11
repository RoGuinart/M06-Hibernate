package dam.m06.uf2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App 
{
	static SessionFactory sessionFactory = null;
	static Session session = null;

	public static void tearUp()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static void tearDown()
	{
		session.close();
	}

	public static void mostraSports()
	{
		Query<Sport> consulta =  session.createQuery("from sports", Sport.class);
		//Query<Sports> consulta =  session.createQuery();
		java.util.List<Sport> results = consulta.list();
		System.out.println("Mostrant tots els esports: "+consulta.list().size());
		
		for (Sport result : results) {
			System.out.println(result.getCode() + ": " + result.getName());
		}
	}

	public static void mostraAthletes()
	{
		Query<Athlete> consulta =  session.createQuery("from athletes", Athlete.class);
		//Query<Sports> consulta =  session.createQuery();
		java.util.List<Athlete> results = consulta.list();
		System.out.println("Mostrant tots els esports: "+consulta.list().size());
		
		for (Athlete result : results) {
			System.out.printf (
				"%d: %s -> %d -- %s\n",
				result.getCode(), result.getName(),
				result.getSport().getCode(), 
				result.getSport().getName()
			);
		}
	}



	public static void main( String[] args )
	{
		System.out.println("Connecting...");
		tearUp();

		if(session == null) {
			System.out.println("Session failed.");
			return;
		}

		System.out.println("Connected!!...");

		//nativeQuery();
		mostraSports();
		mostraAthletes();
		tearDown();
	}
}
