package mappedSuperclassinheritance;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "piano")
public class Piano extends Instrument {
}
