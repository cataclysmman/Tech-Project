package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE dateThorne (
  id INT NOT NULL AUTO_INCREMENT,    
  month VARCHAR(30) NOT NULL,   
  day INT NOT NULL, 
  event VARCHAR(30) NOT NULL,   
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "dateThorne")
public class DateThorne {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "month")
   private String month;

   @Column(name = "day")
   private Integer day;
   
   @Column(name = "event")
   private String event;

   public DateThorne() {
   }

   public DateThorne(Integer id, String month, Integer day, String event) {
      this.id = id;
      this.month = month;
      this.day = day;
      this.event = event;
   }

   public DateThorne(String month, int day, String event) {
      this.month = month;
      this.day = day;
      this.event = event;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getMonth() {
      return month;
   }

   public void setMonth(String month) {
      this.month = month;
   }

   public Integer getDay() {
      return day;
   }

   public void setDay(Integer day) {
      this.day = day;
   }

   public String getEvent() {
	      return event;
	   }

	   public void setEvent(String event) {
	      this.event = event;
	   }
   
   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.month + ", " + this.day + ", " + this.event;
   }
}