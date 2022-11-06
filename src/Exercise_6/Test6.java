package Exercise_6;

public class Test6 {
    public static void testExercise6() {
        System.out.println("---------------------\n" +
                "| Решение задания 6 |\n" +
                "---------------------");
        System.out.println("Первая проверка осуществляется по файлам input.txt и output.txt");
        System.out.println("Вторая проверка осуществляется по ссылке и файлу output_by_url.txt");
        EncodingConverter encodingConverter = new EncodingConverter();
        encodingConverter.Convertation("src/Exercise_6/input.txt", "src/Exercise_6/output.txt", "utf8", "cp1251");
        encodingConverter.Convertation("https://ru.wikipedia.org/wiki/Kotlin", "src/Exercise_6/output_by_url.txt", "utf8", "utf32");
    }
}
