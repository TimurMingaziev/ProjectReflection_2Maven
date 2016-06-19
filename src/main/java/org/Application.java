package org;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.Classes.A;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Application {
    private static Integer countTh = 10;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
//
//        int count =1;
//
//        long  startTime=System.nanoTime();
//        for (int i=0;i<count;i++) {
//
//            Class c = Class.forName("org.Classes.A");
//            Method method = c.getMethod("setNameA",new Class[]{String.class});
//            method.invoke(c.newInstance(),new Object[]{"str"});
//
//        }
//        System.out.println(System.nanoTime()-startTime);
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        startTime=System.nanoTime();
//        for (int i=0;i<count;i++) {
//            FastClass fastClass = FastClass.create(A.class);
//            FastMethod fastMethod = fastClass.getMethod("setNameA",new Class[]{String.class});
//            fastMethod.invoke(fastClass.newInstance(),new Object[]{"str"});
//
//        }
//        System.out.println(System.nanoTime()-startTime);

    }


}
