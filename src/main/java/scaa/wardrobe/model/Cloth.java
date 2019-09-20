package scaa.wardrobe.model;

import org.springframework.format.annotation.DateTimeFormat;
import scaa.wardrobe.category.ClothSize;
import scaa.wardrobe.category.Color;
import scaa.wardrobe.category.Status;
import scaa.wardrobe.category.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "clothnumber"))
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long clothId;

    private String clothNumber;

    @Size(min = 3, max = 100)
    @NotNull(message = "Name can't be empty")
    private String name;

    private Type type;

    private Status status;

    private ClothSize size;

    private Color color;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date bought is required")
    @PastOrPresent
    private Date dateReceived;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateRemoved;

    public Cloth() {
    }

    public Cloth(String clothNumber, @Size(min = 3, max = 100) @NotNull(message = "Name can't be empty") String name, Type type, Status status, ClothSize size, Color color, @NotNull(message = "Date bought is required") @PastOrPresent Date dateReceived, @PastOrPresent Date dateRemoved) {
        this.clothNumber = clothNumber;
        this.name = name;
        this.type = type;
        this.status = status;
        this.size = size;
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

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
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

    @Override
    public String toString() {
        return "Cloth{" +
                "clothId=" + clothId +
                ", clothNumber='" + clothNumber + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", size=" + size +
                ", color=" + color +
                ", dateReceived=" + dateReceived +
                ", dateRemoved=" + dateRemoved +
                '}';
    }
}
