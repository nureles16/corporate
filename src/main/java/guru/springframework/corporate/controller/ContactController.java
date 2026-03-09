package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.ContactsRequest;
import guru.springframework.corporate.dto.response.ContactsResponse;
import guru.springframework.corporate.entity.Contacts;
import guru.springframework.corporate.mapper.ContactsMapper;
import guru.springframework.corporate.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/contacts")
@Tag(name = "Contacts", description = "Contacts page management API")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // 🔹 Просмотр контактов (USER + ADMIN)
    @Operation(summary = "Get contacts information",
            description = "Returns company contact information")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ContactsResponse getContacts() {
        Contacts contacts = contactService.getContacts();
        return ContactsMapper.toResponse(contacts);
    }

    // 🔹 Обновление контактов (ADMIN)
    @Operation(summary = "Update contacts information (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ContactsResponse updateContacts(
            @PathVariable Long id,
            @Valid @RequestBody ContactsRequest request) {
        Contacts existing = contactService.getContactsById(id);
        ContactsMapper.updateEntity(existing, request);
        Contacts updated = contactService.updateContacts(existing);
        return ContactsMapper.toResponse(updated);
    }
}