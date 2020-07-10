import java.util.ArrayList;
import java.util.Optional;

public class Reduce {

    public static void main(String... args) {

        methodReduce();
    }


    public static String methodReduce() {



        ArrayList<String> miList = new ArrayList<String>();

        miList.add("Andrés");
        miList.add("María");
        miList.add("Marco");
        miList.add("Tatiana");
        miList.add("Ali");
        miList.add("Fernando");

        Optional<String> cadena = miList.stream().reduce((String a, String b) -> {
            if (a.length() < b.length()){
                String result1 = a;
                return  result1;
            }else if(a.length() > b.length()){
                String result2 = b;
                return  result2;
            }
            return a;
        });

        System.out.println("Las palabra con menos caracteres es:  "+ cadena.toString());
        return cadena.toString();

    }

}