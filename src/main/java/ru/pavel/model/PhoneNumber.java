package ru.pavel.model;

public record PhoneNumber(String number) {

    public PhoneNumber {
        //  Пропускаем только +XXXXXXXXXXX или 8ХХХХХХХХ
        if(number.length() < 11 || number.length()>12)
            throw new IllegalArgumentException("Invalid phone number. Correct format  +7XXXXXXXXXX or 8XXXXXXXXXX");
        if (number.length() == 12 && number.charAt(0) != '+') {
            throw new IllegalArgumentException("Invalid phone number. Correct format  +7XXXXXXXXXX or 8XXXXXXXXXX");
        }
        if (number.length() == 11 && number.charAt(0) != '8') {
            throw new IllegalArgumentException("Invalid phone number. Correct format  +7XXXXXXXXXX or 8XXXXXXXXXX");
        }
        try {
            Long.parseLong(number.substring(1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid phone number. Must start with '+' and 11 digits");
        }
    }

    @Override
    public String toString() {
        return number;
    }
}



