import generics.GenericBox;
import generics.NormalBox;
import oop.Tiger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class GenericsTests
{
    @DisplayName("test who is parent of all")
    @Test
    void testParentOfAll()
    {
        Object o1=new String();
        Object o2=new Tiger();
        Object o3=new Date();
        Object o4= Calendar.getInstance();
        Assertions.assertNull(01);
        Assertions.assertNull(02);
        Assertions.assertNull(03);
        Assertions.assertNull(04);
    }
    @DisplayName("testing normal box")
    @Test
    void testNormalBox()
    {
        var nb=new NormalBox();
        nb.setContent("this is string");
        var actual=nb.getContent() instanceof String;
        Assertions.assertTrue(actual);

         nb.setContent(new Date());
        actual=nb.getContent() instanceof Date;
        Assertions.assertTrue(actual);

         nb.setContent(new Tiger());
        actual=nb.getContent() instanceof Tiger;
        Assertions.assertTrue(actual);
    }
    @DisplayName("testing generic box-string")
    @Test
    void testGenericBox()
    {
        GenericBox<String> gb1 = new GenericBox<String>();
        gb1.setContent("hello");
        Assertions.assertTrue(gb1.getContent() instanceof String);
    }

    @DisplayName("testing generic box-Tiger")
    @Test
    void testGenericBoxTiger() {
        GenericBox<Tiger> gb2 = new GenericBox<Tiger>();
        gb2.setContent(new Tiger());
        Assertions.assertTrue(gb2.getContent() instanceof Tiger);
    }
}
