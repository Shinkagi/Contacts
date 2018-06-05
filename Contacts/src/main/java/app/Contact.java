package app;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Contact() {}

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getNom() {
    	return this.lastName;
    }
    
    public String getPnom() {
    	return this.firstName;
    }
    
    public Long getId() {
    	return this.id;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}