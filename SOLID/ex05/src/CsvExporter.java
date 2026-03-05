import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ValidationResult validate(ExportRequest req) {
        return ValidationResult.ok(); // CSV  has no length limit
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        // Correct CSV logic uses quoting instead of stripping characters
        String title = quote(ensureNotNull(req.title));
        String body = quote(ensureNotNull(req.body));
        
        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String quote(String s) {
        // Standard CSV format: wrap in quotes and escape existing quotes
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}