import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter 
{
    @Override
    protected ExportResult doExport(ExportRequest req) 
    {
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
// Ye PDF exporter bhi same base contract follow karta hai aur sirf PDF format generate karta hai, so isko bhi Exporter reference se safely substitute kiya ja sakta hai (LSP maintained)