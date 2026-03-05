import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    protected ValidationResult validate(ExportRequest req) {
        
        if (req.body != null && req.body.length() > 20) {
            return ValidationResult.fail("PDF cannot handle content > 20 chars");
        }
        return ValidationResult.ok();
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String body = ensureNotNull(req.body);
        String title = ensureNotNull(req.title);
        String fakePdf = "PDF(" + title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}