package Mankind;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setFirstName(String firstName) {
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }else if (!isStartWithCapitalLetter(firstName)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }else if(!isStartWithCapitalLetter(lastName)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        this.lastName = lastName;
    }

    public boolean isStartWithCapitalLetter(String word) {
        String firstChar = "" + word.charAt(0);
        String firstCharCapital = ("" + word.charAt(0)).toUpperCase();
        if(firstChar.equals(firstCharCapital)){
            return true;
        }else {
            return false;
        }
    }
}
