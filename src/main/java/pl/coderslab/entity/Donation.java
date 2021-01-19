package pl.coderslab.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table (name = "donations")
public class Donation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull (message = "Wartość musi być więkasza niż zero!")
    @Min(value = 1, message = "Wartość musi być więkasza niż zero!")
    private Integer quantity;
    @NotEmpty(message = "Wybierz minimum jedną kategorię!")
    @NotNull (message = "Wybierz minimum jedną kategorię!")
    @ManyToMany
    private List<Category> categories;
    @NotNull(message = "Wybierz minimum jedną instytucję!")
    @ManyToOne
    @JoinColumn(name = "institutionId")
    private Institution institution;
    @NotNull
    @Size(min = 9, max = 15,message = "Numer musi mieć min 9 znaków!")
    private String phoneNumber;
    @NotEmpty(message = "Nie może być puste")
    @NotNull(message = "Nie może być puste")
    private String street;
    @NotEmpty(message = "Nie może być puste")
    @NotNull(message = "Nie może być puste")
    private String city;
    @NotNull
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Wzór: 62-020")
    private String zipCode;
    @NotNull(message = "Nie może być puste")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull(message = "Nie może być puste")
    private LocalTime pickUpTime;
    @NotNull(message = "Nie może być null")
    private String pickUpComment;


    public Donation() {
    }

    public Donation(Long id, Integer quantity, @NotNull List<Category> categories, Institution institution, String phoneNumber, String street, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}
