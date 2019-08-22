package scaa.wardrobe.model.hats;

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
public class Hat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long hatId;

    @NotNull(message = "Hat number can't be null")
    private String hatNumber;

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

    public Hat() {
    }

    public Hat(@NotNull(message = "Hat number can't be null") String hatNumber, @Size(min = 3, max = 100) @NotNull(message = "Hat name can't be empty") String name, Type type, Status status, Color color, @NotNull(message = "Date bought is required") @PastOrPresent Date dateReceived, @PastOrPresent Date dateRemoved) {
        this.hatNumber = hatNumber;
        this.name = name;
        this.type = type;
        this.status = status;
        this.color = color;
        this.dateReceived = dateReceived;
        this.dateRemoved = dateRemoved;
    }

    public long getHatId() {
        return hatId;
    }

    public void setHatId(long hatId) {
        this.hatId = hatId;
    }

    public String getHatNumber() {
        return hatNumber;
    }

    public void setHatNumber(String hatNumber) {
        this.hatNumber = hatNumber;
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
        if (!(o instanceof Hat)) return false;

        Hat hat = (Hat) o;

        if (hatId != hat.hatId) return false;
        return hatNumber != null ? hatNumber.equals(hat.hatNumber) : hat.hatNumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (hatId ^ (hatId >>> 32));
        result = 31 * result + (hatNumber != null ? hatNumber.hashCode() : 0);
        return result;
    }
}
