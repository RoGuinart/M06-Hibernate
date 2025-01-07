package dam.m06.uf2;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name ="athletes")
@Table(name ="athletes")
public class Athlete implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "code", unique = true, nullable = false)
	private long code;

	@Column(name = "name", length = 60)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sport_code")
	private Sport sport;

	public Athlete()
	{

	}

	public Athlete(long code)
	{
		this.code = code;
	}

	public Athlete(long code, String name)
	{
		this.code = code;
		this.name = name;
	}

	public Athlete(long code, String name, Sport sport) {
		this.code = code;
		this.name = name;
		this.sport = sport;
	}

	public Athlete(String name, Sport sport)
	{
		this.name = name;
		this.sport = sport;
	}

	public long getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public Sport getSport()
	{
		return sport;
	}

	public void setCode(long code)
	{
		this.code = code;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSport(Sport sport)
	{
		this.sport = sport;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
