package clsobj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest
{
    @DisplayName("car invalid object")
    @Test
    void testCarInvalidObject(){
        Car car=null;
        Assertions.assertNull(car);
    }
    @DisplayName("car valid object")
    @Test
    void testCarValidObject(){
        Car car=new Car();//u created object
        Assertions.assertNotNull(car);
    }
    @DisplayName("car speed by default constructor")
    @Test
    void testCarSpeedDefault(){
        Car car=new Car();

        int expectedSpeed=10;
        int actualSpeed=car.speed;
        Assertions.assertEquals(expectedSpeed, actualSpeed);
    }
    @DisplayName("car speed by Paramerterized constructor")
    @Test
    void testCarSpeedParamerterized(){
        Car car=new Car(100);

        int expectedSpeed=100;
        int actualSpeed=car.speed;
        Assertions.assertEquals(expectedSpeed, actualSpeed);
    }

}
