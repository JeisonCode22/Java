import java.util.Scanner;

public class Validation {
    private static int day;
    private static int month;
    private static int year;

    public static boolean validateYear() {
        boolean yearValidated = false;
        if (((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) && year <= 2099) {
            yearValidated = true;
            return yearValidated;
        } else if (year >= 1900 && year <= 2099) {
            return yearValidated = false;
        }
        return yearValidated;
    }

    public static boolean validateMonth() {
        boolean monthValidated;
        if (month >= 1 && month <= 12) {
            monthValidated = true;
            return monthValidated;
        } else {
            monthValidated = false;
            return monthValidated;
        }
    }

    public static boolean validateDay() {
        boolean dayValidated = false;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day >= 1 && day <= 31) {
                return dayValidated = true;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 1 && day <= 30) {
                return dayValidated = true;
            }
        } else if (validateYear() == true && month == 2) {
            if (day >= 1 && day <= 29) {
                return dayValidated = true;
            }
        } else if (validateYear() == false && month == 2) {
            if (day >= 1 && day <= 28) {
                return dayValidated = true;
            }
        }
        return dayValidated;
    }


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor ingrese un dia");
        day = entrada.nextInt();
        System.out.println("Por favor ingrese un mes");
        month = entrada.nextInt();
        System.out.println("Por favor ingrese un año");
        year = entrada.nextInt();
        validateYear();
        validateMonth();
        validateDay();
        if (year >= 1900 && year <= 2099 && validateMonth() && validateDay()) {
            System.out.println("Su fecha es " + day + "/" + month + "/" + year + " continue con el sgte paso");
        } else {
            System.out.println("Su fecha es invalida");
        }
    }
}


