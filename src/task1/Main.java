package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZooClub zc = new ZooClub();
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("1-Додати учасника клубу");
            System.out.println("2-Додати тваринку до учасника клубу");
            System.out.println("3-Видалити тваринку з учасника клубу");
            System.out.println("4-Видалити учасника з клубу");
            System.out.println("5-Видалити конкретну тваринку зі всіх власників");
            System.out.println("6-Вивести на екран зооклуб");
            System.out.println("7-Вийти з програми");

            switch (s.nextInt()){
                case 1:{
                    zc.addPerson();
                    System.out.println();
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 2:{
                    zc.addPetToPerson();
                    System.out.println();
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 3:{
                    zc.removePetFromPerson();
                    System.out.println();
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 4:{
                    zc.removePerson();
                    System.out.println();
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 5:{
                    zc.removePetFromAllPersons();
                    System.out.println();
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 6:{
                    zc.showMap();
                    System.out.println();
                    break;
                }
                case 7:{
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
