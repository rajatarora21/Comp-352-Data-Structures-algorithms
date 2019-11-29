import java.util.Objects;

public class Car
{
    String key ;
    String name;
    int order;

    public Car(String key,String name,int order){
        this.key = key;
        this.name = name;
        this.order=order;
    }
    public String getName(){
        return name;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return " This car's owner is "+ name+" with licence place "+key;
    }

}
