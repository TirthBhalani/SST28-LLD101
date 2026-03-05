public abstract class Exporter {
   
    public final ExportResult export(ExportRequest req) {
        //we handle null checks in the exporter only.
        if (req == null) throw new IllegalArgumentException("Request cannot be null");

        //  Subclass-specific validation (Preconditions)
        ValidationResult vr = validate(req);
        if (!vr.isValid()) {
            throw new IllegalArgumentException(vr.getErrorMessage());
        }

        // Conversion (Implementation)
        return doExport(req);
    }

    protected abstract ValidationResult validate(ExportRequest req);
    protected abstract ExportResult doExport(ExportRequest req);

    protected String ensureNotNull(String s) {
        return s == null ? "" : s;
    }
}