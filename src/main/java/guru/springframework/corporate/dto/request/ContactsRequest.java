package guru.springframework.corporate.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContactsRequest {

    @Schema(description = "Company phone number", example = "+996 555 123456")
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[+0-9\\-() ]+$", message = "Invalid phone format")
    private String phone;

    @Schema(description = "Company email", example = "info@company.com")
    @Email(message = "Email must be valid")
    private String email;

    @Schema(description = "Company address", example = "Bishkek, Chuy Avenue 120")
    @NotBlank(message = "Address is required")
    private String address;

    @Schema(description = "Google Maps URL", example = "https://maps.google.com/...")
    private String googleMapUrl;

    // Getters & Setters
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGoogleMapUrl() { return googleMapUrl; }
    public void setGoogleMapUrl(String googleMapUrl) { this.googleMapUrl = googleMapUrl; }
}