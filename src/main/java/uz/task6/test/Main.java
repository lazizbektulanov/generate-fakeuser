package uz.task6.test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesGrouping;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        File firstname = new File("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\csv\\firstname-female.csv");
//        File russian_names = new File("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\csv\\russian_names.csv");
//        File russian_surnames = new File("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\csv\\russian_surnames.csv");
        //        readFileWithScanner(firstname);
//        readFileWithBufferedReader(firstname);
//        readUTF8WithBufferedRead(russian_names);
//        csvRead(firstname);
//        csvReadByIndex("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\csv\\german-postcodes.csv");
//        csvReadByIndex("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\res_csv\\data_ru\\firstname.csv");
        javaFaker();
    }

    private static void readUTF8WithBufferedRead(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)
        ) {
            String str;
            int count = 0;
            while ((str = reader.readLine()) != null) {
                System.out.println(str.substring(str.indexOf(';') + 1, str.indexOf(';', 7)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithBufferedReader(File file) throws IOException {
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");
            System.out.println(values[0]);
        }
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void readFileWithScanner(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }

    private static void csvRead(File file) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\csv\\firstname.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Name", "Pol")
                        .withIgnoreHeaderCase()
                        .withTrim());

        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column
                String Name = csvRecord.get("Name");
                String Pol = csvRecord.get("Pol");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + Name);
                System.out.println("Pol : " + Pol);
                System.out.println("---------------\n\n");
            }
        }

    }

    private static void csvReadByIndex(String path) throws IOException {
        Reader reader = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);
        CSVPrinter printer = new CSVPrinter(
                new FileWriter("C:\\Users\\User\\Desktop\\Itransition\\Task6\\src\\main\\resources\\static\\res_csv\\data_de\\city-code-region.csv"),
                CSVFormat.DEFAULT);
        int count = 0;
        List<String> address = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
////            long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
//            int x = random.nextInt(900) + 100;
//            int y = random.nextInt(9000000) + 1000000;
//
//            printer.printRecord("+49(" + x + ")" + y);
//        }

        for (CSVRecord record : records) {
            address.add(record.get(0));
        }
        Collections.shuffle(address);

        for (String s : address) {
            if (count == 1000) break;
            printer.printRecord(s);
            count++;
        }
        printer.flush();
        printer.close();
    }

    private static void javaFaker() {
//        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"),new RandomService());
//        System.out.println(fakeValuesService.);

//        for (int i = 0;i<10;i++){
//            System.out.println(faker1.phoneNumber().phoneNumber());
//        }
//        System.out.println("=============================================");
//        Faker faker2 = new Faker(Locale.GERMAN,new Random(100));
//        for (int i = 0;i<10;i++){
//            System.out.println(faker1.phoneNumber().phoneNumber());
//        }
//        Faker faker = new Faker();
//        System.out.println(faker.hacker());

        Faker faker1 = new Faker(Locale.GERMAN, new Random(100));
//        Random random = new Random(100L);
//        Random random1  = new Random(random.nextInt());
//        Random random2 = new Random(random1.nextInt());
//        System.out.println(random.nextInt());
//        System.out.println(random1.nextInt());
//        System.out.println(random2.nextInt());
//        System.out.println("=======================");
//        Random random3 = new Random(100L);
//        Random random4  = new Random(random3.nextInt());
//        Random random5 = new Random(random4.nextInt());
//        System.out.println(random3.nextInt());
//        System.out.println(random4.nextInt());
//        System.out.println(random5.nextInt());

       Random random = new Random(12);
        System.out.println(random.nextInt(3));
        System.out.println(random.nextInt(3));
        Random random1 = new Random(12);
        generate(random1);
    }
    public static void generate(Random random){
        System.out.println(random.nextInt(3));
        System.out.println(random.nextInt(3));
    }



//    public static String repl(String data) {
//        Random random = new Random();
//        int changeFromIndex = random.nextInt(data.length());
//        int changeToIndex = random.nextInt(data.length());
//        char[] chars = data.toCharArray();
//        char changeFrom = chars[changeFromIndex];
//        chars[changeFromIndex] = chars[changeToIndex];
//        chars[changeToIndex] = changeFrom;
//        StringBuilder result = new StringBuilder();
//        for (char aChar : chars) {
//            result.append(aChar);
//        }
//        return result.toString();
//
//
//    }
}

