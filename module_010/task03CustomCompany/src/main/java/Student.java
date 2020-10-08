import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    @GenericGenerator(

            name = "ID_GENERATOR",
            strategy = "enhanced-sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name ="sequence_name",
                            value = "JP_SEQUENCE"
                    ),
                    @org.hibernate.annotations.Parameter(
                            name = "initial_value",
                            value = "2222"
                    )
            }
    )
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "university")
    private String university;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
