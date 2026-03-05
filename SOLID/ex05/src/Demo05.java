public class Demo05 {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        
        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        
        System.out.println("PDF: " + safe(pdf, req));
        System.out.println("CSV: " + safe(csv, req));
        System.out.println("JSON: " + safe(json, req));
    }

     // This method demonstrates Substitutability.
     // It works with ANY Exporter. It expects that the Exporter might throw an IllegalArgumentException if validation fails, and it handles it uniformly.
     
    private static String safe(Exporter e, ExportRequest r) {
        try {
            ExportResult out = e.export(r);
            return "OK bytes=" + out.bytes.length;
        } catch (IllegalArgumentException ex) {
            // All exporters now throw the same exception type for validation errors
            return "ERROR: " + ex.getMessage();
        } catch (Exception ex) {
            return "UNEXPECTED ERROR: " + ex.getMessage();
        }
    }
}