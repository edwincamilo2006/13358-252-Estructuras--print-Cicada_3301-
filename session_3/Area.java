public class AreasFiguras {
    public static void main(String[] args) {
        // Valores predefinidos
        double lado, radio, baseT, alturaT, baseR, alturaR;
        lado = 5;
        radio = 3;     // círculo
        baseT = 6;     // triángulo
        alturaT = 4;
        baseR = 8;     // rectángulo
        alturaR = 3;

        // Cálculos de áreas
        double areaCuadrado = lado * lado;
        double areaCirculo = Math.PI * Math.pow(radio, 2);
        double areaTriangulo = (baseT * alturaT) / 2;
        double areaRectangulo = baseR * alturaR;

        // Mostrar resultados
        System.out.println("Área del cuadrado: " + areaCuadrado);
        System.out.println("Área del círculo: " + areaCirculo);
        System.out.println("Área del triángulo: " + areaTriangulo);
        System.out.println("Área del rectángulo: " + areaRectangulo);
    }
}