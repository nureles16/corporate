package guru.springframework.corporate.controller;

import guru.springframework.corporate.dto.request.ContactsRequest;
import guru.springframework.corporate.dto.response.ContactsResponse;
import guru.springframework.corporate.entity.Contacts;
import guru.springframework.corporate.mapper.ContactsMapper;
import guru.springframework.corporate.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // 🔹 Просмотр контактов (USER + ADMIN)
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ContactsResponse getContacts() {
        Contacts contacts = contactService.getContacts();
        return ContactsMapper.toResponse(contacts);
    }

    // 🔹 Обновление контактов (ADMIN)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ContactsResponse updateContacts(@PathVariable Long id,
                                           @Valid @RequestBody ContactsRequest request) {
        Contacts existing = contactService.getContactsById(id);
        ContactsMapper.updateEntity(existing, request);
        Contacts updated = contactService.updateContacts(existing);
        return ContactsMapper.toResponse(updated);
    }
}