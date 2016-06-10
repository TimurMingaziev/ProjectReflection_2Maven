package org;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.Classes.A;
import org.Classes.Z;
import org.openjdk.jmh.Main;
import org.Classes.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Application {
    private static Integer countTh = 10;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
//
        long startTime=0;
        int count =1500000;

        startTime=System.nanoTime();
        for (int i=0;i<count;i++) {

            Class c = Class.forName("org.Classes.A");
            Class[] paramTypes = new Class[]{String.class};
            Method m = c.getMethod("setNameA", paramTypes);
            m.invoke(c.newInstance(), new Object[]{"str"});


        }
        System.out.println(System.nanoTime()-startTime);

////////////////////////////////////////////////////////////////////////////////////////////////////////

        startTime=System.nanoTime();
        for (int i=0;i<count;i++) {

            FastClass fastClass = FastClass.create(A.class);
            FastMethod fastMethod = fastClass.getMethod(A.class.getDeclaredMethod("setNameA", String.class));
            fastMethod.invoke(fastClass.newInstance(),new Object[]{"str"});

        }
        System.out.println(System.nanoTime()-startTime);

//
//        a.setNameA("");

    }


}
