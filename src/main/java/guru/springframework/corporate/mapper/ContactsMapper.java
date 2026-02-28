package guru.springframework.corporate.mapper;

import guru.springframework.corporate.dto.request.ContactsRequest;
import guru.springframework.corporate.dto.response.ContactsResponse;
import guru.springframework.corporate.entity.Contacts;

public class ContactsMapper {

    public static ContactsResponse toResponse(Contacts contacts) {
        ContactsResponse response = new ContactsResponse();
        response.setId(contacts.getId());
        response.setPhone(contacts.getPhone());
        response.setEmail(contacts.getEmail());
        response.setAddress(contacts.getAddress());
        response.setGoogleMapUrl(contacts.getGoogleMapUrl());
        response.setUpdatedAt(contacts.getUpdatedAt());
        return response;
    }

    public static Contacts toEntity(ContactsRequest request) {
        Contacts contacts = new Contacts();
        contacts.setPhone(request.getPhone());
        contacts.setEmail(request.getEmail());
        contacts.setAddress(request.getAddress());
        contacts.setGoogleMapUrl(request.getGoogleMapUrl());
        return contacts;
    }

    public static void updateEntity(Contacts contacts, ContactsRequest request) {
        contacts.setPhone(request.getPhone());
        contacts.setEmail(request.getEmail());
        contacts.setAddress(request.getAddress());
        contacts.setGoogleMapUrl(request.getGoogleMapUrl());
    }
}