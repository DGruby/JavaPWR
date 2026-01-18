import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {

    private List<String> cleanedLines;
    private List<VisitRecord> visits;
    private int emptyLinesRemoved;

    public CSVProcessor(String filePath) throws IOException {
        cleanedLines = new ArrayList<>();
        visits = new ArrayList<>();
        emptyLinesRemoved = 0;

        loadAndCleanFile(filePath);
        createVisitRecords();
    }

    private void loadAndCleanFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // remove quotes and trim
            line = line.replace("\"", "").trim();

            if (line.isEmpty()) {
                emptyLinesRemoved++;
            } else {
                cleanedLines.add(line);
            }
        }

        reader.close();
    }

    private void createVisitRecords() {
        for (String line : cleanedLines) {
            visits.add(new VisitRecord(line));
        }
    }

    // ----- GETTERS -----

    public List<String> getCleanedLines() {
        return cleanedLines;
    }

    public List<VisitRecord> getVisits() {
        return visits;
    }

    public int getEmptyLinesRemoved() {
        return emptyLinesRemoved;
    }
}

