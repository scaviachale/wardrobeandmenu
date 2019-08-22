package scaa.wardrobe.model.cloth;

import scaa.wardrobe.category.Color;
import scaa.wardrobe.category.Status;
import scaa.wardrobe.category.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "hatnumber"))
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long clothId;

    @NotNull(message = "Hat number can't be null")
    private String clothNumber;

    @Size(min = 3, max = 100)
    @NotNull(message = "Hat name can't be empty")
    private String name;

    private Type type;

    private Status status;

    private Color color;

    @NotNull(message = "Date bought is required")
    @PastOrPresent
    private Date dateReceived;

    @PastOrPresent
    private Date dateRemoved;

    public Cloth() {
    }

    public Cloth(@NotNull(message = "Hat number can't be null") String clothNumber, @Size(min = 3, max = 100) @NotNull(message = "Hat name can't be empty") String name, Type type, Status status, Color color, @NotNull(message = "Date bought is required") @PastOrPresent Date dateReceived, @PastOrPresent Date dateRemoved) {
        this.clothNumber = clothNumber;
        this.name = name;
        this.type = type;
        this.status = status;
        this.color = color;
        this.dateReceived = dateReceived;
        this.dateRemoved = dateRemoved;
    }

    public long getClothId() {
        return clothId;
    }

    public void setClothId(long clothId) {
        this.clothId = clothId;
    }

    public String getClothNumber() {
        return clothNumber;
    }

    public void setClothNumber(String clothNumber) {
        this.clothNumber = clothNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloth)) return false;

        Cloth cloth = (Cloth) o;

        if (clothId != cloth.clothId) return false;
        return clothNumber != null ? clothNumber.equals(cloth.clothNumber) : cloth.clothNumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (clothId ^ (clothId >>> 32));
        result = 31 * result + (clothNumber != null ? clothNumber.hashCode() : 0);
        return result;
    }
}
