package Forums.Session7;

public class Arrays {
    public static void main(String[] args) {
        System.out.println("Array 1d");
        String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Sunday" };

        // do-while
        System.out.println("1. Use For-loop");
        int i = 0;
        do {
            System.out.println("- " + days[i]);
            i++;
        } while (i < days.length);

        // for-loop
        System.out.println("2. Use For-loop");
        for (String d : days) {
            System.out.println("- " + d);
        }
        System.out.println("------------------------------");
        System.out.println("Array 2d");
        String entry[][] = { { "Florence", "735-1234", "Manila" }, { "Joyce", "983-3333", "Quezon City" },
                { "Becca", "456-3322", "Manila" } };
        for (int j = 0; j < entry.length; j++) {

            System.out.println("isi array");
            for (int k = 0; k < entry[j].length; k++) {
                System.out.println(entry[k][j]);
            }
            System.out.println("--------");
            System.out.println("nama : " + entry[j][0]);
            System.out.println("Tel.#: " + entry[j][1]);
            System.out.println("Address: " + entry[j][2]);
            System.out.println("------------------------");
        }
    }
}