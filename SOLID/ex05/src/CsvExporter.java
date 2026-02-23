import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter 
{
    @Override
    protected ExportResult doExport(ExportRequest req) 
    {
        String title = escapeCsv(req.title);
        String body = escapeCsv(req.body);
        
        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeCsv(String field) 
    {
        if (field == null || field.isEmpty()) 
        {
            return "";
        }
        
        if (field.contains(",") || field.contains("\n") || field.contains("\"")) 
        {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        
        return field;
    }
}
// Ye CSV exporter base Exporter ke contract ko follow karta hai aur sirf format encoding handle karta hai, so subtype safely replace ho sakta hai without breaking behavior (proper LSP)