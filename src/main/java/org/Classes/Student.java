package org.Classes;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.openjdk.jmh.Main;
//import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Home on 10.06.2016.
 */


public class Student {
//private String name="";


    //@Benchmark
    public void testDir_SetterA() {

        A a = new A();
        a.setNameA("str");

    }

   // @Benchmark
    public void testDir_GetterA(){
        A a = new A();
        a.getNameA();
    }

    @Benchmark
    public void testReflection_GetterA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = new A();
        Class c = a.getClass();
        Method m = c.getMethod("getNameA");
        m.invoke(a);
    }

    @Benchmark
    public void testReflectionCGLIB_GetterA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = new A();
        FastClass c = FastClass.create(A.class);
        FastMethod fastMethod = c.getMethod(A.class.getMethod("getNameA"));
        fastMethod.invoke(a, new Object[]{});
    }

  //  @Benchmark
    public void testReflection_SetterA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        A a = new A();
        Class c = a.getClass();
        Class[] paramTypes = new Class[] {String.class};
        Method m = c.getMethod("setNameA", paramTypes);
        m.invoke(a, "str");

    }

  //  @Benchmark
    public void   testReflectionCGLIB_SetterA() throws NoSuchMethodException, InvocationTargetException {

        A a1 = new A();
        FastClass fastClass = FastClass.create(A.class);
        FastMethod fastMethod = fastClass.getMethod(A.class.getMethod("setNameA", String.class));
        fastMethod.invoke(a1, new Object[]{"str"});
    }

  //   @Benchmark
    public void testDir_CreateInstA(){

        A z = new A();
    }

 //   @Benchmark
    public void testDir_CreateInstZ(){

        Z z = new Z();
    }

   // @Benchmark
    public void testReflection_CreateInstA() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = null;
            c = Class.forName("org.Classes.A");
            Object obj = c.newInstance();
            A a = (A) obj;
    }

 //   @Benchmark
    public void testReflection_CreateInstZ() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = null;

            c = Class.forName("org.Classes.Z");
            Object obj = c.newInstance();
            Z z = (Z) obj;
    }

}
