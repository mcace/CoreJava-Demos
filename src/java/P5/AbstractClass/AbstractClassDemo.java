package p5.abstractClass;

/**
 * Created by Mc on 2016/12/3.
 */
class AbstractClassDemo {
    public static void main(String[] args) {
        //利用多态性把父类对象变量指向子类
        Person[] persons = new Person[2];
        persons[0] = new Student("Jim", "computer science");
        persons[1] = new Employee("Tom", 8000);
        for (Person person : persons) {
            System.out.println(person.getName() + " is " + person.getDescription());
        }
    }
}
