package dam.m06.uf2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

public class DAO
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
		sessionFactory.close();
	}

	public static List<Sport> getSports()
	{
		SelectionQuery<Sport> q = session.createSelectionQuery("from sports", Sport.class);
		List<Sport> sports = q.getResultList();
		return sports;
	}

	public static List<Athlete> getAthletes()
	{
		SelectionQuery<Athlete> q = session.createSelectionQuery("from athletes", Athlete.class);
		List<Athlete> aths = q.getResultList();
		return aths;
	}

	public static void addSport(Sport spt)
	{
		// TODO: use createMutationQuery instead
		Transaction t = session.beginTransaction();
		session.save(spt);
		t.commit();
	}

	public static void addAthlete(Athlete ath)
	{
		Transaction t = session.beginTransaction();
		session.save(ath);
		t.commit();
	}

	public static List<Athlete> findAthletesByName(String name)
	{
		String hql = "FROM athletes ath WHERE UPPER(ath.name) LIKE UPPER(:name)";
		SelectionQuery<Athlete> q = session.createSelectionQuery(hql, Athlete.class);

		q.setParameter("name", '%' + name + '%');

		List<Athlete> aths = q.getResultList();

		return aths;
	}

	public static List<Athlete> findAthletesWithSport(Sport sport)
	{
		String hql = "FROM athletes ath WHERE ath.sport = :sport";
		SelectionQuery<Athlete> q = session.createSelectionQuery(hql, Athlete.class);

		q.setParameter("sport", sport);

		List<Athlete> aths = q.getResultList();

		return aths;
	}
}
