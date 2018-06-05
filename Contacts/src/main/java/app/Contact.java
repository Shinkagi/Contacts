package app;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min=2, max=30)
    private String firstName;

	@NotNull
    @Size(min=2, max=30)
    private String lastName;

    public Contact() {}
    public Contact(String firstName, String lastName)
    {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
    public String getNom() {
    	return this.lastName;
    }

	public void setNom(String lastName) {
		this.lastName = lastName;
	}
    
    public String getPnom() {
    	return this.firstName;
    }
    
    public void setPnom(String firstName) {
		this.firstName = firstName;
	}
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public String getModif() {
    	return "/modifier/"+this.id;
    }
    public String getSuppr() {
    	return "/supprimer/"+this.id;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}