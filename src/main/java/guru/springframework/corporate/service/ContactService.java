package guru.springframework.corporate.service;

import guru.springframework.corporate.entity.Contacts;
import guru.springframework.corporate.exception.NotFoundException;
import guru.springframework.corporate.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // 🔹 Получить контакты (берем первый, т.к. одна запись)
    public Contacts getContacts() {
        return contactRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Contacts not found"));
    }

    // 🔹 Получить контакты по ID
    public Contacts getContactsById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contacts not found with id: " + id));
    }

    // 🔹 Обновить контакты (ADMIN)
    public Contacts updateContacts(Contacts contacts) {
        contacts.setUpdatedAt(LocalDateTime.now());
        return contactRepository.save(contacts);
    }
}