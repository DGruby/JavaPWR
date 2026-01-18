import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVProcessor processor;
        ReportGenerator reportGenerator;
        try {
            processor = new CSVProcessor("/Users/poczt1/Desktop/intro to programming/JavaPWR/list10/src/Data/data.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<VisitRecord> visits = processor.getVisits();
        int emptyLines = processor.getEmptyLinesRemoved();

        reportGenerator = new ReportGenerator(visits, emptyLines);
        reportGenerator.generateReport();

        for(VisitRecord visitRecord : visits) {
            System.out.println(visitRecord.toString());
        }

    }
}