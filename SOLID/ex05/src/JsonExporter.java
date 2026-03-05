import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    protected ValidationResult validate(ExportRequest req) {
        return ValidationResult.ok();
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String title = escape(ensureNotNull(req.title));
        String body = escape(ensureNotNull(req.body));
        
        String json = "{\"title\":\"" + title + "\",\"body\":\"" + body + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}