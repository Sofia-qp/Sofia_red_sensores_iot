public class BancoDePruebas {

    private static final int[] TAMANOS = {
            1000,
            100000,
            1000000
    };

    public static void experimentoUno() {

        System.out.println(
                "=== EXPERIMENTO 1: BUSQUEDA LINEAL ==="
        );

        System.out.printf(
                "%12s %16s%n",
                "lecturas",
                "comparaciones"
        );

        for (int n : TAMANOS) {

            LecturaSensor[] datos =
                    GeneradorDatos.generar(n);

            String objetivo =
                    GeneradorDatos.timestampEnPosicion(n - 1);

            BuscadorLecturas
                    .busquedaLinealPorTimestamp(
                            datos,
                            objetivo
                    );

            System.out.printf(
                    "%12d %16d%n",
                    n,
                    BuscadorLecturas.getComparaciones()
            );
        }

        System.out.println();
    }

    public static void experimentoDos() {

        System.out.println(
                "=== EXPERIMENTO 2: LINEAL VS BINARIA ==="
        );

        for (int n : TAMANOS) {

            LecturaSensor[] datos =
                    GeneradorDatos.generar(n);

            String objetivo =
                    GeneradorDatos.timestampEnPosicion(n - 1);

            BuscadorLecturas
                    .busquedaLinealPorTimestamp(
                            datos,
                            objetivo
                    );

            int lineal =
                    BuscadorLecturas.getComparaciones();

            BuscadorLecturas
                    .busquedaBinariaPorTimestamp(
                            datos,
                            objetivo
                    );

            int binaria =
                    BuscadorLecturas.getComparaciones();

            System.out.println(
                    "N = " + n +
                            " | Lineal = " + lineal +
                            " | Binaria = " + binaria
            );
        }

        System.out.println();
    }

    public static void experimentoTres() {

        System.out.println(
                "=== EXPERIMENTO 3: DATO INEXISTENTE ==="
        );

        LecturaSensor[] datos =
                GeneradorDatos.generar(100000);

        String objetivo =
                GeneradorDatos.timestampInexistente();

        BuscadorLecturas
                .busquedaLinealPorTimestamp(
                        datos,
                        objetivo
                );

        int lineal =
                BuscadorLecturas.getComparaciones();

        BuscadorLecturas
                .busquedaBinariaPorTimestamp(
                        datos,
                        objetivo
                );

        int binaria =
                BuscadorLecturas.getComparaciones();

        System.out.println(
                "Lineal comparaciones: " + lineal
        );

        System.out.println(
                "Binaria comparaciones: " + binaria
        );

        System.out.println();
    }

    public static void experimentoCuatro() {

        System.out.println(
                "=== EXPERIMENTO 4: PM2.5 ==="
        );

        LecturaSensor[] datos =
                GeneradorDatos.generar(10000);

        int aciertosBinaria = 0;

        for (int i = 0; i < 20; i++) {

            double valor =
                    datos[i * 137].getPm25();

            int posicion =
                    BuscadorLecturas
                            .busquedaBinariaPorPm25(
                                    datos,
                                    valor
                            );

            if (posicion >= 0) {
                aciertosBinaria++;
            }
        }

        System.out.println(
                "Aciertos binaria PM2.5: "
                        + aciertosBinaria
                        + " de 20"
        );

        System.out.println();
    }
}
