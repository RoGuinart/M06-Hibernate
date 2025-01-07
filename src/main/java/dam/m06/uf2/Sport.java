package dam.m06.uf2;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name ="sports")
@Table(name ="sports")
public class Sport implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "code", unique = true, nullable = false)
	private long code;

	@Column(name = "name", length = 60)
	private String name;

	public Sport()
	{

	}

	// User input
	public Sport(long code)
	{
		this.code = code;
	}

	// DB SELECT
	public Sport(long code, String name)
	{
		this.code = code;
		this.name = name;
	}

	public Sport(String name)
	{
		this.name = name;
	}

	public long getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public void setCode(long code)
	{
		this.code = code;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
