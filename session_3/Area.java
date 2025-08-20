public class AreasFiguras {
    public static void main(String[] args) {
        // Valores predefinidos
        double lado, radio, baseT, alturaT, baseR, alturaR;
        lado = 5;      // Cuadrado
        radio = 3;     // Círculo
        baseT = 6;     // Triángulo
        alturaT = 4;   // Triángulo
        baseR = 8;     // Rectángulo
        alturaR = 3;   // Rectángulo

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