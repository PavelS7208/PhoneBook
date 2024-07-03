package ru.pavel.model;

import java.util.*;

public class PhoneBook {


    private final Map<String, List<PhoneNumber>> storage = new HashMap<>();


    public List<String> getNames() {
        return new ArrayList<String>(storage.keySet().stream().toList());
    }

    public boolean addPhoneContact(String name, PhoneNumber phoneNumber) {
        return storage.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public boolean addPhoneContact(String name, List<PhoneNumber> phoneNumberList) {
        if(!phoneNumberList.isEmpty()) {
            storage.computeIfAbsent(name, k -> new ArrayList<>()).addAll(phoneNumberList);
            return true;
        }
        return false;
    }

    public List<PhoneNumber> getPhoneNumberList(String name) {
        if(storage.containsKey(name)) {
            return storage.get(name);
        }
        return new ArrayList<PhoneNumber>();
    }

    public boolean isContains(String key) {
        return storage.containsKey(key);
    }
}
