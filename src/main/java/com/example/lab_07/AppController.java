package com.example.lab_07;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ArrayList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.util.Comparator;
import java.util.ResourceBundle;

// Klasa implementuje interfejs Initializable umożliwiający wykonanie czynności inicjalizacyjnych
public class AppController implements Initializable {

    // Deklaracja pól powiązanych z elementami interfejsu użytkownika
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField ageField;
    @FXML
    private ChoiceBox<String> sortChoiceBox;

    public int idCounter = 0;

    // Lista przechowująca opcje sortowania wyświetlane w ChoiceBox
    private String[] sortOptions = {"Po imieniu", "Po nazwisku", "Po wieku", "Po kolejnosci dodania" };

    // Metoda wypełniająca ChoiceBox po załadowaniu pliku FXML ale przed wyświetleniem okna
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // Dodanie opcji sortowania do ChoiceBoxa
        sortChoiceBox.getItems().addAll(sortOptions);
    }

    // Kolekcja zawierajaca obiekty klasy patient
    ArrayList<Patient> patients = new ArrayList<>();

    // Metoda dodajaca pacjeta do kolekcji
    @FXML
    public void addPatient() {

        // Pobranie danych z pól tekstowych
        String firstNameToWrite = firstNameField.getText();
        String lastNameToWrite = lastNameField.getText();
        int ageToWrite = Integer.parseInt(ageField.getText());
        int idToWrite = idCounter;
        idCounter++;

        // Utworzenie nowego obiektu klasy patient
        Patient newPatient = new Patient(firstNameToWrite, lastNameToWrite, ageToWrite,idToWrite);
        // Dodanie pacjenta do kolekcji
        patients.add(newPatient);

        // Rest pól tekstowych po dodaniu pacjenta
        firstNameField.clear();
        lastNameField.clear();
        ageField.clear();
    }

    // Metoda wyświetlająca w konsoli dane pacjentów
    @FXML
    public void printPatients() {
        // Pobranie wybranej opcji sortowania
        String selectedSortOption = sortChoiceBox.getValue();
        // Wyświetlenie komunikatu w konsoli, jeśli nie wybrano sposobu sortowania
        if (selectedSortOption == null) {
            System.out.println("Wybierz opcję sortowania.");
            return;
        }

        // Sortowanie pacjentów na podstawie wybranej opcji sortowania
        switch (selectedSortOption) {
            case "Po imieniu":
                patients.sort(Comparator.comparing(Patient::getFirstName));
                break;
            case "Po nazwisku":
                patients.sort(Comparator.comparing(Patient::getLastName));
                break;
            case "Po wieku":
                patients.sort(Comparator.comparingInt(Patient::getAge));
                break;
            case "Po kolejnosci dodania" :
                patients.sort(Comparator.comparing(Patient::getId));
                break;
            default:
                System.out.println("Nieznana opcja sortowania.");
                return;
        }

        // Wyświetlenie danych pacjentów
        System.out.println(patients);

    }

}