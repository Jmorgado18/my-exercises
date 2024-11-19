package mappedSuperclassinheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guitar")
public class Guitar extends Instrument{

}
