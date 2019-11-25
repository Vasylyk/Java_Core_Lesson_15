package task1;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class ZooClub {
    Map<Person,ArrayList<Animal>>map = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    String nextInt;
    String scName;

    public void addPerson(){
        System.out.println("Напишіть ім`я учасника клубу");
        scName = sc.nextLine();
        System.out.println("Напишіть вік учасника");
        int age = sc.nextInt();
        nextInt=sc.nextLine();
        Person p = new Person(scName,age);
        map.put(p,new ArrayList<>());
    }

    void addPetToPerson(){
        if (isPersonExist()){
            Set<Map.Entry<Person,ArrayList<Animal>>>entrySet=map.entrySet();
            Iterator<Map.Entry<Person,ArrayList<Animal>>>iterator=entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<Person, ArrayList<Animal>> meNext = iterator.next();
                if (meNext.getKey().getName().equalsIgnoreCase(scName)){
                    System.out.println("Напишіть вид тваринки");
                    String petType = sc.nextLine();
                    System.out.println("Напишіть ім`я тваринки");
                    String petName = sc.nextLine();
                    meNext.getValue().add(new Animal(petType,petName));
                }
            }
        }

    }

    void removePetFromPerson(){
        if (isPersonExist()){
            Set<Map.Entry<Person,ArrayList<Animal>>>entrySet=map.entrySet();
            Iterator<Map.Entry<Person,ArrayList<Animal>>>iterator=entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<Person, ArrayList<Animal>> meNext = iterator.next();
                if (meNext.getKey().getName().equalsIgnoreCase(scName)){
                    System.out.println("Напишіть ім`я тваринки, яку хочете видалити");
                    String petName = sc.nextLine();
                    boolean flag = true;
                    ArrayList<Animal> animalsList = meNext.getValue();
                    Iterator<Animal>iterator1=animalsList.iterator();
                    while (iterator1.hasNext()){
                        if (iterator1.next().getName().equalsIgnoreCase(petName)){
                            iterator1.remove();
                            flag = false;
                        }
                    }
                    if (flag){
                        System.out.println("Такої тваринки в цього учасника клубу немає");
                    }
                }
            }
        }
    }

    void removePerson(){
        if (isPersonExist()){
            Set<Map.Entry<Person,ArrayList<Animal>>>entrySet=map.entrySet();
            Iterator<Map.Entry<Person,ArrayList<Animal>>>iterator=entrySet.iterator();
            while (iterator.hasNext()){
                if (iterator.next().getKey().getName().equalsIgnoreCase(scName)){
                    iterator.remove();
                }
            }
        }
    }

    void removePetFromAllPersons(){
        System.out.println("Напишіть вид тваринки, яку хочете видалити");
        String petType = sc.nextLine();
        boolean flag = true;
        Set<Map.Entry<Person,ArrayList<Animal>>> entrySet = map.entrySet();
        Iterator<Map.Entry<Person,ArrayList<Animal>>>iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> meNext = iterator.next();
            Iterator<Animal>animalIterator=meNext.getValue().iterator();
            while (animalIterator.hasNext()) {
                if (animalIterator.next().getAnimalType().equalsIgnoreCase(petType)) {
                    animalIterator.remove();
                    flag = false;
                }
            }
        }
        if (flag){
            System.out.println("Такої тваринки немає");
        }
    }

    public boolean isPersonExist(){
        System.out.println("Напишіть ім`я учасника клубу");
        scName = sc.nextLine();
        Set<Map.Entry<Person,ArrayList<Animal>>>entrySet=map.entrySet();
        Iterator<Map.Entry<Person,ArrayList<Animal>>>iterator=entrySet.iterator();
        boolean re = true;
        boolean flag = true;
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> meNext = iterator.next();
            if (meNext.getKey().getName().equalsIgnoreCase(scName)){
                re = true;
                flag = false;
            }
        }
        if (flag){
            System.out.println("Такого учасника немає");
            re = false;
        }
        return re;
    }




    void showMap(){
        Set<Map.Entry<Person,ArrayList<Animal>>>entrySet=map.entrySet();
        for (Map.Entry<Person,ArrayList<Animal>> m : entrySet){
            System.out.println(m);
        }
    }

}
