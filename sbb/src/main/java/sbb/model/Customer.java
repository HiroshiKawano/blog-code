package sbb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity @Data
public class Customer {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @JsonIgnore private long userId;

    @NotEmpty(message="{lastName}{NotEmpty}")
    @Size(max=50, message="{lastName}{Max}")
    private String lastName;

    @NotEmpty(message="{firstName}{NotEmpty}")
    @Size(max=50, message="{firstName}{Max}")
    private String firstName;

    @NotEmpty(message="{lastNameKana}{NotEmpty}")
    @Size(max=50, message="{lastNameKana}{Max}")
    private String lastNameKana;

    @NotEmpty(message="{firstNameKana}{NotEmpty}")
    @Size(max=50, message="{firstNameKana}{Max}")
    private String firstNameKana;

    @JsonIgnore @Version private long version;

    @JsonIgnore @Column(insertable=false, updatable=false)
    private Timestamp createdTime;

	public void copyTo(Customer dst) {
		dst.setLastNameKana(this.lastNameKana);
    	dst.setFirstNameKana(this.firstNameKana);
    	dst.setLastName(this.lastName);
    	dst.setFirstName(this.firstName);
	}
}