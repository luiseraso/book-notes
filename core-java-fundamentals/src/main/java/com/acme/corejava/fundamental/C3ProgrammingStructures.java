package com.acme.corejava.fundamental;

public class C3ProgrammingStructures {

    public static void main(String[] args) {
        C3ProgrammingStructures app = new C3ProgrammingStructures();
        app.numberExamples();
    }

    public void numberExamples() {
        //Overflow when adding and upper casting
        int a = 2_147_483_647; // Integer.MAX_VALUE
        int b = a + 1; // Overflow
        long c = a + 1L;
        float x = c+1L;
        double y = c+1L;

        System.out.println("Overflow when adding and upper casting");
        System.out.printf("int: %d\n", a);
        System.out.printf("int: %d (overflow)\n", b);
        System.out.printf("long: %d\n", c);
        System.out.printf("float: %f (overflow)\n", x);
        System.out.printf("doble: %f\n", y);
    }

    public void stringExamples() {
        // Literal Strings and ==
        String var1 = "Hola";
        String var2 = "Hola, my TV not work!";
        String var3 = "Hola";
        String var4 = var2.substring(0, 4);

        System.out.println(var1 == var2); //false
        System.out.println(var1 == var3); //true
        System.out.println(var1 == var4); //false

        // Supplementary characters can't be stored in single char type
        String text = "\uD835\uDD46 is the set of octonions";
        System.out.println(text);
        int[] codePoints = text.codePoints().toArray();
        for(int i : codePoints){
            System.out.println((char) i);
        }
        String str = new String(codePoints, 0, codePoints.length);
        System.out.println(str);
    }

    public void blockStrings() {
        String dato1 = "{\"nombre\":\"Luis\",\"apellido\":\"Eraso\",\"direccion\":{\"pais\":\"col\",\"ciudad\":\"sabaneta\"}}";
        String dato2 = "{\n" +
                "  \"nombre\": \"Luis\",\n" +
                "  \"apellido\": \"Eraso\",\n" +
                "  \"direccion\": {\n" +
                "    \"pais\": \"col\",\n" +
                "    \"ciudad\": \"sabaneta\"\n" +
                "  }\n" +
                "}";

        String dato3 = """
            {
              "nombre": "Luis",
              "apellido": "Eraso",
              "direccion": {
                "pais": "col",
                "ciudad": "sabaneta"
              }
            }
            """;

        System.out.println(dato1);
        System.out.println(dato2);
        System.out.println(dato3);
    }
}

enum Size {
    LARGE, MEDIUM, SMALL;
}