package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
       Client client = new Client();
       client.id = 222;

        Class<? extends Client> refl = client.getClass();

        Field[] declaredField = refl.getDeclaredFields();
        for (Field field : declaredField) {
            System.out.println(field.getModifiers() + " " + field.getType() + " " + field.getName());
        }

        Integer o = (Integer) declaredField[0].get(client);
        System.out.println(o);

        declaredField[0].set(client, 10);
        Integer o1 = (Integer) declaredField[0].get(client);
        System.out.println(o1);

        Annotation[] declaredAnnotations = declaredField[0].getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }

        TudaSuda annotation = declaredField[0].getAnnotation(TudaSuda.class);

//        for (Field field : declaredField) {
//            TudaSuda annotation = field.getAnnotation(TudaSuda.class);
//
//
//            if (annotation.is0k()){
//                System.out.println("IS OK");
//            }
//            else {
//                System.out.println("FALSE");
//            }
//
//        }



    }
}